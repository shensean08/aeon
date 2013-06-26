
//****************************************************************************/
// Class Download
//
//****************************************************************************/
function Download(second) {
	
	var _this = this;
	_this.downloadHint = null;
	_this.downloadComfirm;
	_this.downloading;
	
	// download 
	// type 0 GOOGLE MAP 1 picture
	Download.prototype.download = function() {

		if (placeSelectMenu != null) {
			placeSelectMenu.dispose();
		}
		ge.setBalloon(null);
		

			if (userSession.isLoginIn() == false) {
			
			//_this.downloadComfirm = new HtmlHint("先に登録してください。",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
			_this.downloadComfirm = new HtmlHint("",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
			_this.downloadComfirm.setFontSize(42);
			_this.downloadComfirm.setBackgroundImage("coment-4.jpg");
			_this.downloadComfirm.show();
			setTimeout(function(){
				_this.downloadComfirm.hide();
			},3000);
			
			return;
		}
		
		_this.downloadHint = new HtmlHint("",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
		_this.downloadHint.setFontSize(42);
		_this.downloadHint.setBackgroundImage("coment-1.jpg");
		_this.downloadHint.show();
		QRcodeReader.read(function(QRCode){
			_this.downloadHint.hide();
			//_this.downloading = new HtmlHint("",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
			//_this.downloading.setBackgroundImage("coment-3.jpg");
			//_this.downloading.show();
			setTimeout(function(){


				var msg = "";

				

				if (userSession.authenticate(QRCode) == true) {

					sideMenu.hide();
					routeButton.hide();
					
					//upload img to server
						

					/// sean add start
					//document.DownloadApplet.DownloadImage("1315492432","0","start","0","1","end","2","3");
					document.DownloadApplet.DownloadImage("http://dps.or.jp/aeonsite/",QRCode,"0",selectedPlace.name,selectedPlace.location.lat(),selectedPlace.location.lng(),"","","");
					// sean add end

					msg = " ";
					
					sideMenu.show();
					routeButton.show();

	

				} else {

					msg = "認証が失敗しまいました。";

				}
			
				//_this.downloading.hide();	
				_this.downloadComfirm = new HtmlHint(msg,0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
				_this.downloadComfirm.setFontSize(42);
				_this.downloadComfirm.setBackgroundImage("coment-2.jpg");
				_this.downloadComfirm.show();
				setTimeout(function(){
					_this.downloadComfirm.hide();
				},3000);

			},5000);
		});
		//},200);
	};

	Download.prototype.downloadRoute = function(name,lat,lng) {
		
		
		//alert(selectedPlace.name + ",  " + selectedPlace.location.lat() + ":" + selectedPlace.location.lng());

		//alert(name + ", " + lat + " : " + lng);
	
		ge.setBalloon(null);


		if (userSession.isLoginIn() == false) {

			
			//_this.downloadComfirm = new HtmlHint("先に登録してください。",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
			_this.downloadComfirm = new HtmlHint("",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
			_this.downloadComfirm.setFontSize(42);
			_this.downloadComfirm.setBackgroundImage("coment-1.jpg");
			_this.downloadComfirm.show();
			setTimeout(function(){
				_this.downloadComfirm.hide();
			},3000);
			
			return;
		}
		
		//_this.downloadHint = new HtmlHint("",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);//QRかざしてください
		_this.downloadHint = new HtmlHint("",0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
		_this.downloadHint.setFontSize(42);
		_this.downloadHint.setBackgroundImage("coment-1.jpg");
		_this.downloadHint.show();
		QRcodeReader.read(function(QRCode){
			_this.downloadHint.hide();
			setTimeout(function(){


				var msg = "";

				

				if (userSession.authenticate(QRCode) == true) {
					//upload img to server

					

					sideMenu.hide();
					routeButton.hide();

					// sean add start
					//document.DownloadApplet.DownloadImage("1315492432","0","start","0","1","end","2","3");

					document.DownloadApplet.DownloadImage("http://dps.or.jp/aeonsite/",QRCode,0,selectedPlace.name,selectedPlace.location.lat(),selectedPlace.location.lng(),name,lat,lng);

					// sean add end
					
					routeButton.show();
					sideMenu.show();
					msg = "";

				} else {

					msg = "認証が失敗しまいました。";

				}

				
				_this.downloadComfirm = new HtmlHint(msg,0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
				_this.downloadComfirm.setFontSize(42);
				_this.downloadComfirm.setBackgroundImage("coment-2.jpg");//ダウンロード完了しました
				_this.downloadComfirm.show();
				setTimeout(function(){
					_this.downloadComfirm.hide();
				},20000);
			},5000);
		});
		//},200);
	};
	// hide Hint
	// 
	Download.prototype.hideHint = function() {
		if (_this.downloadHint != null) {
			_this.downloadHint.hide();
		}
	};
}

