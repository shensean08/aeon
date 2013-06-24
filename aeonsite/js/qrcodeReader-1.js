//****************************************************************************/
// Class QRCode Reader
//
//****************************************************************************/
function QRCodeReader() {

	var _this = this;
	var QRCode = "";
	this.keydownHandel="";
	this.isReading = 0;

	//Read QRCode and call back
	//
	QRCodeReader.prototype.read = function(callback) {
		//this.isReading = 1;
//		alert("do call back");
//		alert(callback1);
//		callback1();
		//callback1("666036050");
/*
 		var retVal = prompt("QRCode : ", "");
		callback(retVal);

		//alert("QRCode is : " +  retVal );

		//		alert('読み込み開始しますDebug');
		this.isReading = 1;

		ge.getWindow().blur();
		//alert(1);
		loginHint.hintDiv.focus();
		//alert("focused");
*/

		QRCode = "";

		//addEventHandler(window, 'keydown', function(e) {
		window.onkeydown = function(e) {

			_this.keydownHandel = arguments.callee;
			e = e || window.event;
			//alert('keydown' + e);
			var keycode = e.which ? e.which : e.keyCode;
			if (keycode !=13) {
				QRCode = QRCode + (keycode-48);
				//alert(keycode);
			} else {
				//alert(QRCode);

				//removeEventHandler(window, 'keydown', keydownHandel);
				_this.stopRead();
//				screenSave.resetCount();

				callback(QRCode);////////////////////////

				//callback("1315492432");
				//alert('qr bypass');
				//callback("666036050");
				}

			e.preventDefault();
			e.stopPropagation();
		};

	};

	//stop read
	//
	QRCodeReader.prototype.stopRead = function() {
		//removeEventHandler(window, 'keydown', _this.keydownHandel);
		window.onkeydown = function(e) {};
		//QRCode = "";
		_this.isReading = 0;
	};

	// event handling helper
	//
	function addEventHandler(obj, evt, handler) {
		if ('attachEvent' in obj)
			obj.attachEvent('on' + evt, handler);
		else
			obj.addEventListener(evt, handler, false);
	}

	// event handling helper
	//
	function removeEventHandler(obj, evt, handler) {
		if ('detachEvent' in obj) {
			obj.detachEvent('on' + evt, handler);
		}
		else {
			obj.removeEventListener(evt, handler, false);
		}
	}

	return this;
}

