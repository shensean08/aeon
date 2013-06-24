
//****************************************************************************/
// Class HTML Hint
//
//****************************************************************************/
//function HtmlHint(id,text,left,top,width,height) {
function HtmlHint(text,left,top,width,height) {

	var _this = this;
	this.isHide = 1;

	// create div
	this.hintDiv = document.createElement("div");
	this.hintDiv.className="htmlHint";
	this.hintDiv.innerHTML = text;

	// create an IFRAME shim for the button
	this.iframeShim = document.createElement('iframe');
	this.iframeShim.frameBorder = 0;
	this.iframeShim.scrolling = 'no';
	this.iframeShim.src = (navigator.userAgent.indexOf('MSIE 6') >= 0) ?
	  '' : 'javascript:void(0);';

	// position the button and IFRAME shim
	this.hintDiv.style.position = this.iframeShim.style.position = 'absolute';
	this.hintDiv.style.left = this.iframeShim.style.left = left + 'px';
	this.hintDiv.style.top = this.iframeShim.style.top = top + 'px';
	this.hintDiv.style.width = this.iframeShim.style.width = width + 'px';
	this.hintDiv.style.height = this.iframeShim.style.height = height + 'px';
	this.hintDiv.style.lineHeight =  height + 'px';

	// set up z-orders
	this.hintDiv.style.zIndex = 9;
	this.iframeShim.style.zIndex = this.hintDiv.style.zIndex - 1;

	///////////////////////
	//method start
	///////////////////////

	//show hint
	//
	HtmlHint.prototype.show = function() {


		_this = this;

		if (this.isHide == 1) {
			document.body.appendChild(this.hintDiv);
			document.body.appendChild(this.iframeShim);
			//startFlicker();
			this.isHide = 0;
		}
	};

	//hide hint
	//
	HtmlHint.prototype.hide = function() {
		try {
			if (this.isHide == 0) {
				document.body.removeChild(this.hintDiv);
				document.body.removeChild(this.iframeShim);
				//stopFlicker();
				this.isHide = 1;
			}
		} catch(err) {
			debug("HTML HtmlHint hide err:" + err.description);
		}
	};

	//set font size
	//
	HtmlHint.prototype.setFontSize = function(fontSize) {
		this.hintDiv.style.fontSize = fontSize + 'px';
	};

	//set Background Image
	//
	HtmlHint.prototype.setBackgroundImage = function(image) {
		this.hintDiv.style.backgroundImage = "url(" + URL_IMG + image + ")";
		this.hintDiv.style.backgroundRepeat = "no-repeat";

	};

	HtmlHint.prototype.addClickListener = function(funcname){
		this.hintDiv.addEventListener("click",alert('clickedddddd'));
		this.hintDiv.addEventListener("click",funcname);
	};

	//font flicker
	//
	var index = 0;
	var flickerFlg = 1;
	var flickerInterval = null;
	var color = ['#000000','#080808','#101010','#181818','#202020','#282828','#303030','#383838',
				'#404040','#484848','#505050','#585858','#606060','#686868','#707070','#787878',
				'#808080','#888888','#909090','#989898','#A0A0A0','#A8A8A8','#B0B0B0','#B8B8B8',
				'#C0C0C0','#C8C8C8','#D0D0D0','#D8D8D8','#E0E0E0','#E8E8E8','#F0F0F0','#F8F8F8'];
	//start flicker
	//
	var startFlicker = function() {
		flickerInterval = setInterval(function() {
			_this.hintDiv.style.color = color[index];
			if (flickerFlg == 1) {
				index ++;
				if (index == 31) {
					flickerFlg = -1;
				}
			} else {
				index --;
				if (index == 0) {
					flickerFlg = 1;
				}
			}
		},40);
	};
	//stop flicker
	//
	var stopFlicker = function() {
		clearInterval(flickerInterval);
		flickerInterval = null;
	};

	return this;
}

	//<input type="text" id="debug">
	//<input type="button" id="test1" value ="test1" onclick="testBtn1();">
	//<input type="button" id="test2" value ="test2" onclick="testBtn2();">
