//****************************************************************************/
// Class Global
// define global Variable and global method
//****************************************************************************/

function Global() {
	
}

// show image over google earth
//
Global.showfrontImage = function() {
	
	var icon = ge.createIcon('');
    icon.setHref(URL_IMG + "hazardmap_new.png");
    var overlay = ge.createScreenOverlay('');
	overlay.setIcon(icon);
    overlay.getOverlayXY().set(1, ge.UNITS_PIXELS, 1, ge.UNITS_INSET_PIXELS);
    overlay.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
    overlay.getSize().set(SCREEN_WIDTH-1, ge.UNITS_PIXELS, SCREEN_HEIGHT-1, ge.UNITS_PIXELS);
    ge.getFeatures().appendChild(overlay);
};

// set LookAt that can see whole earth
//
Global.setLookAtInit = function() {
	var lookat = ge.createLookAt('');
	lookat.set(30, 135,
		0, // altitude
		ge.ALTITUDE_RELATIVE_TO_GROUND,
		0, // heading
		0, // straight-down tilt
		30000000 // range (inverse of zoom)
	);
	ge.getView().setAbstractView(lookat);
};

// reset to init
//
Global.reset2Init = function() {
	
	QRcodeReader.stopRead();
	Global.setLookAtInit();
	ge.setBalloon(null);
	if (selectedPlace != null) {
		selectedPlace.dispose();
	}
	if (shelter != null) {
		shelter.dispose();
	}
	if (placeSelectMenu != null) {
		placeSelectMenu.dispose();
	}
	sideMenu.hide();
	loginButton.hide();
	loginHint.hide();
	cancelButton.hide();
	download.hideHint();
	routeButton.hide();
	appHint1.hide();
	appHint2.hide();
	releaseKml('shelter');
	releaseKml('tsunami2');
	releaseLine();
	
};
//****************************************************************************/
// Class Global End
//****************************************************************************/
