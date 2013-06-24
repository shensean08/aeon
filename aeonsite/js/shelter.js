
//****************************************************************************/
// Class Shelter
//
//****************************************************************************/
function Shelter(_selectedPlace) {

	var _this = this;
	this.shelterInfo;
	this.isSearching = 0;
	this.shelterMarkArr;
	this.shelterBalloonArr;
	this.elevation;
	this.routePlaceMark;
	var i;

	this.selectedPlace = _selectedPlace;

	// search and show
	//
	Shelter.prototype.searchAndShow = function(elevation) {
		ge.setBalloon(null);
		this.search(elevation);
		this.show();
	};

	// search shelter
	//
	Shelter.prototype.search = function(elevation) {

		this.isSearching = 1;
		this.elevation = elevation;

		var request = {
			location: this.selectedPlace.location,
			radius: '1000',
			//types:['police'],
			query: '避難'
		};

		placeService.textSearch(request, function(results, status){

			if (status == google.maps.places.PlacesServiceStatus.OK) {
				_this.shelterInfo = results;
				_this.isSearching = 0;
			}
		});
	};

	// show shelter
	//
	Shelter.prototype.show = function() {

		if (_this.isSearching == 1) {
			setTimeout(_this.show,100);
			return;
		}

		_this.shelterMarkArr = new Array();
		_this.shelterBalloonArr = new Array();

		for (i = 0; i < _this.shelterInfo.length; i++){
	  		createShelterMark(_this.shelterInfo[i],i);
		}

		var lookAt = ge.getView().copyAsLookAt(ge.ALTITUDE_RELATIVE_TO_GROUND);
		lookAt.setAltitude(60);
		lookAt.setRange(2000.0); //default is 0.0
		ge.getView().setAbstractView(lookAt);

	};

	// create shelter mark
	//
	var createShelterMark = function(shelter,idx) {

		var shelterLoc = shelter.geometry.location;
		var locations = [];
		locations.push(shelterLoc);

		// Create a LocationElevationRequest object using the array's one value
		var positionalRequest = { 'locations': locations };

		// Initiate the location request

		elevator.getElevationForLocations(positionalRequest, function(results, status) {
			if (status == google.maps.ElevationStatus.OK) {
				// Retrieve the first result
				if (results[0]) {
					if (results[0].elevation - _this.elevation > 0) {

						var marker = ge.createPlacemark('');

						// Define a custom icon.
						var icon = ge.createIcon('');
						icon.setHref(URL_IMG + 'pin_shelter.png');

						var style = ge.createStyle(''); //create a new style
						style.getIconStyle().setIcon(icon); //apply the icon to the style
						style.getIconStyle().setScale(1.6);

						marker.setStyleSelector(style); //apply the style to the placemark
						marker.setName(shelter.name);
						// Set the placemark's location.
						var point = ge.createPoint('');
						point.setLatitude(shelterLoc.lat());
						point.setLongitude(shelterLoc.lng());
						marker.setGeometry(point);

						// Add the placemark to Earth.
						_this.shelterMarkArr.push(marker);
						ge.getFeatures().appendChild(marker);

						(function(shelter,idx) {
							google.earth.addEventListener(marker, 'click', function(event) {

								// prevent the default balloon from popping up
								event.preventDefault();
								var balloon = new ShelterBalloon(shelter,idx,event);
								balloon.show();
								_this.shelterBalloonArr.push(balloon);
							});
						})(shelter,idx);
					}
				} else {
					alert('No results found');
				}
			} else {
				alert('Elevation service failed due to: ' + status);
			}
		});

	};



	// shelter route from selected place
	//
	Shelter.prototype.shelterRoute = function() {
		var des = new google.maps.LatLng(currentClickedObject['lat'],currentClickedObject['lng']);
		ge.setBalloon(null);
		var request = {
			origin: this.selectedPlace.location,//new google.maps.LatLng(latCur,lngCur),
			destination: des,
			travelMode: google.maps.TravelMode.WALKING
		};
		// Route the directions and pass the response to a
		// function to create markers for each step.
		directionsService.route(request, function(response, status) {
			if (status == google.maps.DirectionsStatus.OK) {
				drawSteps(response,des);
				//drawSteps(response, _this.shelterInfo[idx].geometry.location);
				currentClickedObject['lat'] = null;
				currentClickedObject['lng'] = null;
			}
		});
	};

	// draw route step by step
	//
	var drawSteps = function(directionResult,destination){
		// For each step, place a marker, and add the text to the marker's
		// info window. Also attach the marker to an array so we
		// can keep track of it and remove it when calculating new
		// routes.

		if(currentLine){
			ge.getFeatures().removeChild(currentLine);
			currentLine = null;
		}

		if (_this.routePlaceMark != null) {
			_this.routePlaceMark.setGeometry(null);
		}

		var routeGeometry = ge.createMultiGeometry('');

		var myRoute = directionResult.routes[0].legs[0];
		var slat = _this.selectedPlace.location.lat();
		var slng = _this.selectedPlace.location.lng();

		for (var i = 0; i < myRoute.steps.length; i++) {
			var line = ge.createLineString('');
			line.getCoordinates().pushLatLngAlt(slat, slng, 0);
			line.getCoordinates().pushLatLngAlt(myRoute.steps[i].start_point.lat(), myRoute.steps[i].start_point.lng(), 0);
			line.setTessellate(true);
			line.setAltitudeMode(ge.ALTITUDE_CLAMP_TO_GROUND);

			routeGeometry.getGeometries().appendChild(line);

			slat = myRoute.steps[i].start_point.lat();
			slng = myRoute.steps[i].start_point.lng();
		}
		if (myRoute.steps.length > 0) {
			var line = ge.createLineString('');
			line.getCoordinates().pushLatLngAlt(slat, slng, 0);
			line.getCoordinates().pushLatLngAlt(myRoute.steps[myRoute.steps.length-1].end_point.lat(), myRoute.steps[myRoute.steps.length-1].end_point.lng(), 0);
			line.setTessellate(true);
			line.setAltitudeMode(ge.ALTITUDE_CLAMP_TO_GROUND);

			routeGeometry.getGeometries().appendChild(line);

			slat = myRoute.steps[myRoute.steps.length-1].end_point.lat();
			slng = myRoute.steps[myRoute.steps.length-1].end_point.lng();
		}
		var line = ge.createLineString('');
		line.getCoordinates().pushLatLngAlt(slat, slng, 0);
		line.getCoordinates().pushLatLngAlt(destination.lat(), destination.lng(), 0);
		line.setTessellate(true);
		line.setAltitudeMode(ge.ALTITUDE_CLAMP_TO_GROUND);

		routeGeometry.getGeometries().appendChild(line);


		_this.routePlaceMark = ge.createPlacemark('');
		_this.routePlaceMark.setGeometry(routeGeometry);

		_this.routePlaceMark.setStyleSelector(ge.createStyle(''));
		var lineStyle = _this.routePlaceMark.getStyleSelector().getLineStyle();
		lineStyle.setWidth(5);
		lineStyle.getColor().set('990088ff');

		ge.getFeatures().appendChild(_this.routePlaceMark);
		currentLine = _this.routePlaceMark;


	};

	// shelter dispose
	//
	Shelter.prototype.dispose = function() {

		var i;

		if (_this.shelterMarkArr != null) {
			for (i = 0; i<this.shelterMarkArr.length; i++) {
				ge.getFeatures().removeChild(this.shelterMarkArr[i]);
			}
			_this.shelterMarkArr = null;
		}

		if (_this.routePlaceMark != null) {
			_this.routePlaceMark.setGeometry(null);
			_this.routePlaceMark = null;
		}
	};

	return this;
}



