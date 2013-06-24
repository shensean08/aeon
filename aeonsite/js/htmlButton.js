
//****************************************************************************/
// Class HTML Button
//
//****************************************************************************/
//function HtmlButton(id,text,left,top,width,height) {
function HtmlButton(text,left,top,width,height) {
	
	this.isHide = 1;
	var _this = this;
	
	//button edge
	this.edgeIcon = ge.createIcon('');
	this.edgeIcon.setHref(URL_IMG + 'btn_earth.png');
	this.edgeOverlay = ge.createScreenOverlay('');
	this.edgeOverlay.setIcon(this.edgeIcon);
	this.edgeOverlay.getOverlayXY().set(left, ge.UNITS_PIXELS, top, ge.UNITS_INSET_PIXELS);
	this.edgeOverlay.getScreenXY().set(0, ge.UNITS_FRACTION, 1, ge.UNITS_FRACTION);
	this.edgeOverlay.getSize().set(width, ge.UNITS_PIXELS, height, ge.UNITS_PIXELS);
	
	// create div
	this.buttonDiv = document.createElement("div");
	this.buttonDiv.className="htmlButton";
	this.buttonDiv.innerHTML = text;
	
	// create an IFRAME shim for the button  
	this.iframeShim;
	this.iframeShim = document.createElement('iframe');  
	this.iframeShim.frameBorder = 0;  
	this.iframeShim.scrolling = 'no';  
	this.iframeShim.src = (navigator.userAgent.indexOf('MSIE 6') >= 0) ?  
	  '' : 'javascript:void(0);';  

	// position the button and IFRAME shim  
	this.buttonDiv.style.position = this.iframeShim.style.position = 'absolute';  
	this.buttonDiv.style.left = this.iframeShim.style.left = left+(width/12) + 'px';  
	this.buttonDiv.style.top = this.iframeShim.style.top = top+(height/10) + 'px';  
	this.buttonDiv.style.width = this.iframeShim.style.width = width-(width/12)*2 + 'px';  
	this.buttonDiv.style.height = this.iframeShim.style.height =  height-(height/10)*2 + 'px';  
	this.buttonDiv.style.lineHeight =  height-(height/10)*2 + 'px';  
	// set up z-orders  
	this.buttonDiv.style.zIndex = 15;  
	this.iframeShim.style.zIndex = this.buttonDiv.style.zIndex - 1;  
	
	///////////////////////
	//method start
	///////////////////////
	
	//show button
	//
	HtmlButton.prototype.show = function() {
		if (this.isHide == 1) {
			ge.getFeatures().appendChild(this.edgeOverlay);
			document.body.appendChild(this.buttonDiv);  
			document.body.appendChild(this.iframeShim);  
			this.isHide = 0;
		}
	};
	
	//hide button
	//
	HtmlButton.prototype.hide = function() {
		try {
			if (this.isHide == 0) {
				ge.getFeatures().removeChild(this.edgeOverlay);
				document.body.removeChild(this.buttonDiv);  
				document.body.removeChild(this.iframeShim);  
				this.isHide = 1;
			}
		} catch(err) {
			debug("HTML Button hide err:" + err.description);
		}
	};
	
	//set font size
	//
	HtmlButton.prototype.setFontSize = function(fontSize) {
		this.buttonDiv.style.fontSize = fontSize + 'px';
	};
	
	//define click event
	//
	HtmlButton.prototype.addClickListener = function(funcName) {
		this.buttonDiv.addEventListener("click", screenSave.resetCount);
		this.buttonDiv.addEventListener("click", funcName);
	};
	
	//dispose
	//
	HtmlButton.prototype.dispose = function() {
		try {
			if (this.isHide == 0) {
				ge.getFeatures().removeChild(this.edgeOverlay);
				document.body.removeChild(this.buttonDiv);  
				document.body.removeChild(this.iframeShim);   
				this.isHide = 1;
			}
		} catch(err) {
			debug("HTML Button dispose err:" + err.description);
		}
	};
	return this;
}

