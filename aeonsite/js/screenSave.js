
//****************************************************************************/
// Class Screen Save
//
//****************************************************************************/
function ScreenSave(second) {

	var _this = this;
	this.timeCount;
	this.screenSaveTime = second;
	//this.isPlaying;
	this.timeCountInterval;

	// set ready
	//
	ScreenSave.prototype.ready = function() {

		_this.timeCount = 0;
		//this.isPlaying = 0;

		this.timeCountInterval = setInterval(function(){
			_this.timeCount++;
			//debug(_this.timeCount);
			if (_this.timeCount == _this.screenSaveTime) {
				//_this.start();

					userSession.loginOut();
					Global.reset2Init();
					flyToOsaka();

			}
		},1000);

		google.earth.addEventListener(ge.getGlobe(), 'mousemove', _this.resetCount);


		/*
		google.earth.addEventListener(ge.getGlobe(), 'mouseup', function(){

			setInterval(focusTxt,200);
		});

		google.earth.addEventListener(ge.getWindow(), "mouseup", function(event) {
			//resetScreenSaveTime();

			//setGeBlur();
			//ge.getWindow().blur();
		});
		*/
	};

	ScreenSave.prototype.resetCount = function() {
		_this.timeCount = 0;
	};
	// screen save start
	//
	ScreenSave.prototype.start = function() {


		if (placeSelectMenu != null) {
			placeSelectMenu.dispose();
		}

		clearInterval(_this.timeCountInterval);
		_this.timeCountInterval = null;
		google.earth.removeEventListener(ge.getGlobe(), 'mousemove', _this.resetCount);

		document.getElementById("map3d").style.visibility = "hidden";
/*

		videoObj.load();

		videoObj.play();
*/

		userSession.loginOut();
		Global.reset2Init();


	};

	// screen save start
	//
	ScreenSave.prototype.stop = function() {

		/*var videoObj = document.getElementById("screenSaveVideo");
		videoObj.width = 0;
		videoObj.height = 0;


		videoObj.pause();
		*/
		document.getElementById("map3d").style.visibility = "visible";
		flyToOsaka();
		_this.ready();
	};
}

