//****************************************************************************/
// Class Place
//
//****************************************************************************/
function Place(name) {
	
	var _this = this;
	this.isHide = 1;
	
	this.altitude = -1;
	this.location;
	
	this.name = name;
	this.address;
	this.isGeocoding = 0;
	
	this.placeMark = ge.createPlacemark('');
	this.ballon;
	
	if (shelter != null) {
		shelter.dispose();
	}
	shelter = new Shelter(_this);
	
	google.earth.addEventListener(this.placeMark, 'click', function(event) {
		// prevent the default balloon from popping up
		event.preventDefault();
		
		//resetScreenSaveTime();
		var info = {
			name: _this.name,
			elevation: '100'
		};
		
		_this.balloon = new PlaceBalloon(info,event);
		_this.balloon.show();
	});
	
	
	// request geocode through call google api
	//
	Place.prototype.geocode = function(address) {
		
		this.address = address;
		_this.isGeocoding = 1;
		geocoder.geocode( { 'address': this.address}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
			
				_this.location = results[0].geometry.location;
				
			} else {
				//alert("Geocode was not successful for the following reason: " + status);
			}
			_this.isGeocoding = 0;
		});
	};
	
	// show place mark
	//
	Place.prototype.show = function() {
		
		if (_this.isGeocoding == 1) {
			setTimeout(_this.show,100);
			return;
		}
		var la = ge.createLookAt('');
		la.set(_this.location.lat(),
				_this.location.lng(),
				60, // altitude
				ge.ALTITUDE_RELATIVE_TO_GROUND,
				0, // heading
				30, // straight-down tilt
				1000 // range (inverse of zoom)
				);
		ge.getView().setAbstractView(la);
		
		
		// Define a custom icon.
		var icon = ge.createIcon('');
		icon.setHref(URL_IMG + 'pin_mine.png');
		
		var style = ge.createStyle(''); //create a new style
		style.getIconStyle().setIcon(icon); //apply the icon to the style
		style.getIconStyle().setScale(2.0);
		
		_this.placeMark.setStyleSelector(style); //apply the style to the placemark
		_this.placeMark.setName(_this.name);
		
		// Set the placemark's location.  
		var point = ge.createPoint('');
		point.setLatitude(_this.location.lat());
		point.setLongitude(_this.location.lng());
		_this.placeMark.setGeometry(point);
		ge.getFeatures().appendChild(_this.placeMark);
		
		_this.isHide = 0;
	};
	
	// hide place mark
	//
	Place.prototype.hide = function() {
		
	};
	
	// show next ballon
	//
	Place.prototype.showNextBalloon = function() {
		_this.balloon.showNext();
	};
	
	// show next ballon
	//
	Place.prototype.showPrevBalloon = function() {
		_this.balloon.showPrev();
	};
	
	// dispose
	//
	Place.prototype.dispose = function() {
		if (this.isHide == 0) {
			ge.getFeatures().removeChild(this.placeMark);
			this.isHide = 1;
		}
	};
	
	return this;
}


