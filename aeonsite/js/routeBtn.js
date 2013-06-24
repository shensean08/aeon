
//****************************************************************************/
// Class draw route button (temp)
//
//****************************************************************************/

function RouteButton() {

	var _this = this;
	this.isHide = 1;

	var routeBtn1Left = (SCREEN_WIDTH / 2) - 200;
	var routeBtn1Top = SCREEN_HEIGHT - 320;
	var routeBtn1Width = 200;
	var routeBtn1Height = 75;

	var routeBtn1Icon = ge.createIcon('');
	routeBtn1Icon.setHref(URL_IMG + 'balloon_btn-G.png');

	this.routeBtn1 = ge.createScreenOverlay('');
	this.routeBtn1.setIcon(routeBtn1Icon);
	this.routeBtn1.getOverlayXY().set(routeBtn1Left, ge.UNITS_PIXELS, routeBtn1Top, ge.UNITS_INSET_PIXELS);
	this.routeBtn1.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.routeBtn1.getSize().set(routeBtn1Width, ge.UNITS_PIXELS, routeBtn1Height, ge.UNITS_PIXELS);

	google.earth.addEventListener(ge.getWindow(), 'click', function(evt) {

	if (evt.getButton() === 0 &&
			isMouseOnButton(evt.getClientX(), evt.getClientY(), routeBtn1Left, routeBtn1Top, routeBtn1Width, routeBtn1Height)){
			//alert('1');
			shelter.shelterRoute(' + idx + ');

		}
		return true;
	});

	var isMouseOnButton = function(mx, my, x, y, width, height) {
		return x <= mx && mx <= x + width && y <= my && my <= y + height;
	};


	RouteButton.prototype.hide = function() {
		if(this.isHide == 0){
			ge.getFeatures().removeChild(this.routeBtn1);

			this.isHide = 1;
		}
	};

	RouteButton.prototype.show = function(){
		if(this.isHide == 1){
			ge.getFeatures().appendChild(this.routeBtn1);

			this.isHide = 0;
		}
	};

	return this;
}
