
//****************************************************************************/
// Class Place Select Menu
//
//****************************************************************************/
function PlaceSelectMenu(userSession) {

	var _this = this;
	this.isHide = 1;

	var titleWidth = 380;
	var titleHeight = 66;
	var titleTop = 210;

	/*
	var placeSelBtnTop = 300;     ///オリジナル
	var placeSelBtnWidth = 300;
	var placeSelBtnHeight = 50;
	*/

	var placeSelBtnTop = 300;     ///オリジナル
	var placeSelBtnWidth = 300;
	var placeSelBtnHeight = 50;

	var _userSession = userSession;
	var placeArr = new Array();

	ge.getOptions().setMouseNavigationEnabled(false);

	var titleIcon = ge.createIcon('');
	titleIcon.setHref(URL_IMG + 'h2-1_earth.png');

	var placeSelOverlay = ge.createScreenOverlay('');
	placeSelOverlay.setIcon(titleIcon);
	placeSelOverlay.getOverlayXY().set(SCREEN_WIDTH/2 - titleWidth/2, ge.UNITS_PIXELS, titleTop, ge.UNITS_INSET_PIXELS);
	placeSelOverlay.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	placeSelOverlay.getSize().set(titleWidth, ge.UNITS_PIXELS, titleHeight, ge.UNITS_PIXELS);

	var i;
	for (i = 0; i < _userSession.placeCount(); i++) {
		placeArr[i] = new HtmlButton(_userSession.getPlaceName(i)
								,SCREEN_WIDTH/2-placeSelBtnWidth/2
								,placeSelBtnTop + (placeSelBtnHeight + 20) * i
								,placeSelBtnWidth
								,placeSelBtnHeight);
		(function(name,address) {
			placeArr[i].addClickListener(function(){
				if (selectedPlace != null) {
					selectedPlace.dispose();
				}
				selectedPlace = new Place(name);
				selectedPlace.geocode(address);
				selectedPlace.show();
				setTimeout(function(){
					ge.getOptions().setMouseNavigationEnabled(true);
					},3000);
				_this.hide();
			});
		})(_userSession.getPlaceName(i),_userSession.getAddress(i));

	}

	///////////////////////
	//method start
	///////////////////////

	//show PlaceSelectMenu
	//
	PlaceSelectMenu.prototype.show = function() {

		if (this.isHide == 1) {
			ge.getFeatures().appendChild(placeSelOverlay);
			var idx;
			for (idx = 0; idx < placeArr.length; idx++) {
				placeArr[idx].show();
			}
			this.isHide = 0;
		}
	};

	//hide PlaceSelectMenu
	//
	PlaceSelectMenu.prototype.hide = function() {

		if (this.isHide == 0) {
			ge.getFeatures().removeChild(placeSelOverlay);
			var i;
			for (i = 0; i < placeArr.length; i++) {
				placeArr[i].hide();
			}
			this.isHide = 1;
		}
	};


	// PlaceSelectMenu dispose
	//
	PlaceSelectMenu.prototype.dispose = function() {

		try {
			if (this.isHide == 0) {
				ge.getFeatures().removeChild(placeSelOverlay);
				var i;
				for (i = 0; i < placeArr.length; i++) {
					placeArr[i].dispose();
				}
				this.isHide = 1;
			}
		} catch(err) {
			debug("PlaceSelectMenu dispose err:" + err.description);
		}
	};

	return this;

}

