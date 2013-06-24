
//****************************************************************************/
// Class Side Menu
//
//****************************************************************************/
function SideMenu() {

	var _this = this;
	this.isHide = 1;


	var sideBtnTsunamiLeft = (SCREEN_WIDTH / 2) - 250;
	var sideBtnTsunamiTop = SCREEN_HEIGHT -240;
	var sideBtnTsunamiWidth = 100;
	var sideBtnTsunamiHeight = 100;

	var sideBtnShelterLeft = (SCREEN_WIDTH / 2) -150;
	var sideBtnShelterTop = SCREEN_HEIGHT -240;
	var sideBtnShelterWidth = 100;
	var sideBtnShelterHeight = 100;

	var sideBtnLoginLeft = (SCREEN_WIDTH / 2) - 50;
	var sideBtnLoginTop = SCREEN_HEIGHT -240;
	var sideBtnLoginWidth = 100;
	var sideBtnLoginHeight = 100;

	var sideBtnDLLeft = (SCREEN_WIDTH / 2) + 50;
	var sideBtnDLTop = SCREEN_HEIGHT -240;
	var sideBtnDLWidth = 100;
	var sideBtnDLHeight = 100;

	var sideBtnHintLeft = (SCREEN_WIDTH / 2) + 150;
	var sideBtnHintTop = SCREEN_HEIGHT -240;
	var sideBtnHintWidth = 100;
	var sideBtnHintHeight = 100;


	var sideBtnQuitLeft = SCREEN_WIDTH - 300;
	var sideBtnQuitTop = SCREEN_HEIGHT -240;
	var sideBtnQuitWidth = 164;
	var sideBtnQuitHeight = 75;


	var sideBtnTsunamiIcon = ge.createIcon('');
	sideBtnTsunamiIcon.setHref(URL_IMG + 'hazardmap-btn-01.png');

	this.sideBtnTsunami = ge.createScreenOverlay('');
	this.sideBtnTsunami.setIcon(sideBtnTsunamiIcon);
	this.sideBtnTsunami.getOverlayXY().set(sideBtnTsunamiLeft, ge.UNITS_PIXELS, sideBtnTsunamiTop, ge.UNITS_INSET_PIXELS);
	this.sideBtnTsunami.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.sideBtnTsunami.getSize().set(sideBtnTsunamiWidth, ge.UNITS_PIXELS, sideBtnTsunamiHeight, ge.UNITS_PIXELS);
	//ge.getFeatures().appendChild(sideBtnTsunami);

	var sideBtnShelterIcon = ge.createIcon('');
	sideBtnShelterIcon.setHref(URL_IMG + 'hazardmap-btn-02.png');

	this.sideBtnShelter = ge.createScreenOverlay('');
	this.sideBtnShelter.setIcon(sideBtnShelterIcon);
	this.sideBtnShelter.getOverlayXY().set(sideBtnShelterLeft, ge.UNITS_PIXELS, sideBtnShelterTop, ge.UNITS_INSET_PIXELS);
	this.sideBtnShelter.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.sideBtnShelter.getSize().set(sideBtnShelterWidth, ge.UNITS_PIXELS, sideBtnShelterHeight, ge.UNITS_PIXELS);
	//ge.getFeatures().appendChild(sideBtnAddrSel);

	var sideBtnLoginIcon = ge.createIcon('');
	sideBtnLoginIcon.setHref(URL_IMG + 'hazardmap-btn-03.png');

	this.sideBtnLogin = ge.createScreenOverlay('');
	this.sideBtnLogin.setIcon(sideBtnLoginIcon);
	this.sideBtnLogin.getOverlayXY().set(sideBtnLoginLeft, ge.UNITS_PIXELS, sideBtnLoginTop, ge.UNITS_INSET_PIXELS);
	this.sideBtnLogin.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.sideBtnLogin.getSize().set(sideBtnLoginWidth, ge.UNITS_PIXELS, sideBtnLoginHeight, ge.UNITS_PIXELS);
	//ge.getFeatures().appendChild(sideBtnAddrSel);

	var sideBtnDLIcon = ge.createIcon('');
	sideBtnDLIcon.setHref(URL_IMG + 'hazardmap-btn-04.png');

	this.sideBtnDL = ge.createScreenOverlay('');
	this.sideBtnDL.setIcon(sideBtnDLIcon);
	this.sideBtnDL.getOverlayXY().set(sideBtnDLLeft, ge.UNITS_PIXELS, sideBtnDLTop, ge.UNITS_INSET_PIXELS);
	this.sideBtnDL.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.sideBtnDL.getSize().set(sideBtnDLWidth, ge.UNITS_PIXELS, sideBtnDLHeight, ge.UNITS_PIXELS);
	//ge.getFeatures().appendChild(sideBtnAddrSel);

	var sideBtnHintIcon = ge.createIcon('');
	sideBtnHintIcon.setHref(URL_IMG + 'hazardmap-btn-05.png');

	this.sideBtnHint = ge.createScreenOverlay('');
	this.sideBtnHint.setIcon(sideBtnHintIcon);
	this.sideBtnHint.getOverlayXY().set(sideBtnHintLeft, ge.UNITS_PIXELS, sideBtnHintTop, ge.UNITS_INSET_PIXELS);
	this.sideBtnHint.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.sideBtnHint.getSize().set(sideBtnHintWidth, ge.UNITS_PIXELS, sideBtnHintHeight, ge.UNITS_PIXELS);



	var sideBtnQuitIcon = ge.createIcon('');
	sideBtnQuitIcon.setHref(URL_IMG + 'hazardmap-btn-quit.png');

	this.sideBtnQuit = ge.createScreenOverlay('');
	this.sideBtnQuit.setIcon(sideBtnQuitIcon);
	this.sideBtnQuit.getOverlayXY().set(sideBtnQuitLeft, ge.UNITS_PIXELS, sideBtnQuitTop, ge.UNITS_INSET_PIXELS);
	this.sideBtnQuit.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.sideBtnQuit.getSize().set(sideBtnQuitWidth, ge.UNITS_PIXELS, sideBtnQuitHeight, ge.UNITS_PIXELS);
	//ge.getFeatures().appendChild(sideBtnQuit);

	google.earth.addEventListener(ge.getWindow(), 'click', function(evt) {
			if (evt.getButton() === 0 &&
				isMouseOnButton(evt.getClientX(), evt.getClientY(),sideBtnTsunamiLeft,sideBtnTsunamiTop,sideBtnTsunamiWidth,sideBtnTsunamiHeight)) {

					toggleKml('tsunami2');

			} else if (evt.getButton() === 0 &&
				isMouseOnButton(evt.getClientX(), evt.getClientY(),sideBtnShelterLeft,sideBtnShelterTop,sideBtnShelterWidth,sideBtnShelterHeight)) {

					toggleKml('shelter');

			} else if (evt.getButton() === 0 &&
				isMouseOnButton(evt.getClientX(), evt.getClientY(),sideBtnLoginLeft,sideBtnLoginTop,sideBtnLoginWidth,sideBtnLoginHeight)) {

				//	SideMenu.hide();
					userSession.loginOut();

					//cancelButton.show();
					loginHint.show();
					//ge.getWindow().blur();
					QRcodeReader.read(function(QRCode){
						//alert(QRCode);
						userSession.requestUserInfo(QRCode,function() {
						//alert(1);
						placeSelectMenu = new PlaceSelectMenu(userSession);
						//alert(2);
						loginHint.hide();
						//alert(3);
						Global.reset2Init();
						placeSelectMenu.show();
						sideMenu.show();
						});
					});

			} else if (evt.getButton() === 0 &&
				isMouseOnButton(evt.getClientX(), evt.getClientY(),sideBtnDLLeft,sideBtnDLTop,sideBtnDLWidth,sideBtnDLHeight)) {

				download.download();

			}else if (evt.getButton() === 0 &&
				isMouseOnButton(evt.getClientX(), evt.getClientY(),sideBtnHintLeft,sideBtnHintTop,sideBtnHintWidth,sideBtnHintHeight)) {

				appHint1.show();

			}else if (evt.getButton() === 0 &&
				isMouseOnButton(evt.getClientX(), evt.getClientY(),sideBtnQuitLeft,sideBtnQuitTop,sideBtnQuitWidth,sideBtnQuitHeight)) {

					userSession.loginOut();
					Global.reset2Init();
					flyToOsaka();
					//screenSave.start();
					//alert(4);
					//screenSave.ready();
			}

			return true;



	});

	// hide side menu
	//
	SideMenu.prototype.hide = function() {

		if (this.isHide == 0) {
				ge.getFeatures().removeChild(this.sideBtnTsunami);
				ge.getFeatures().removeChild(this.sideBtnShelter);
				ge.getFeatures().removeChild(this.sideBtnLogin);
				ge.getFeatures().removeChild(this.sideBtnDL);
				ge.getFeatures().removeChild(this.sideBtnHint);
				ge.getFeatures().removeChild(this.sideBtnQuit);
		this.isHide = 1;
		}
	};

	// show side menu
	//
	SideMenu.prototype.show = function() {

		if (this.isHide == 1) {
				ge.getFeatures().appendChild(this.sideBtnTsunami);
				ge.getFeatures().appendChild(this.sideBtnShelter);
				ge.getFeatures().appendChild(this.sideBtnLogin);
				ge.getFeatures().appendChild(this.sideBtnDL);
				ge.getFeatures().appendChild(this.sideBtnHint);
				ge.getFeatures().appendChild(this.sideBtnQuit);

			this.isHide = 0;

		}
	};

	// check is click button
	//
	var isMouseOnButton = function(mx, my, x, y, width, height) {
		return x <= mx && mx <= x + width && y <= my && my <= y + height;
	};

	return this;
}
