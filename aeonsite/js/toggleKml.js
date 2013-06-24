//****************************************************************************/
// Functions for showing and hiding KML
//
//****************************************************************************/
//////for Shelter
// I think there is a lot better way to do this.

function loadKml(file) {

	var kmlUrl = 'http://192.218.175.137:8080/aeonsite/kml/' + file + '.kml';
	
	google.earth.fetchKml(ge, kmlUrl,  function(kmlObject) {
    	if (kmlObject) {
      		// show it on Earth
      		currentKmlObject[file] = kmlObject;
      		ge.getFeatures().appendChild(kmlObject);
	
		google.earth.addEventListener(kmlObject, 'click', function(event) {

 			var kmlPlacemark = event.getTarget();
			currentClickedObject['name'] = kmlPlacemark.getName();
			currentClickedObject['lat'] = kmlPlacemark.getGeometry().getLatitude();
			currentClickedObject['lng'] = kmlPlacemark.getGeometry().getLongitude();
			//alert(currentClickedObject['name']+currentClickedObject['lat']+currentClickedObject['lng']);
			routeButton.show();
		});

	
    	} else {
      		// bad KML
		alert('kmlLoadFailed');
      		currentKmlObject[file] = null;
	}});
}

function toggleKml(file){

  	if (!currentKmlObject[file]) {
		loadKml(file);
    	}else if(currentKmlObject[file]){
		ge.getFeatures().removeChild(currentKmlObject[file]);
    		currentKmlObject[file] = null;
	}
}

function releaseKml(file){
	
	if(currentKmlObject[file]){
	ge.getFeatures().removeChild(currentKmlObject[file]);
    	currentKmlObject[file] = null;
	}
}

function releaseLine(){
	if(currentLine){
	ge.getFeatures().removeChild(currentLine);
    	currentLine = null;
	}
}
