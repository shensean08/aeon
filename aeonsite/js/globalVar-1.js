//****************************************************************************/
//****************************************************************************/
//****************************************************************************/
// Global Variable 
//
//****************************************************************************/
//****************************************************************************/
//****************************************************************************/

var ge;
var map;
var placeService;
var directionsService;
var elevator;
var geocoder;

var loginHint;			//登録Hint
var loginButton;		//登録ボタン
var QRcodeReader;		//QRCode読む
var userSession;		//登録したユーザ情報
var placeSelectMenu;	//住所選択メニュー
var sideMenu;			//

var selectedPlace;		//選択されている住所 place that be selected
var shelter;			//避難所
var screenSave;			//

var download;

/////////////////////
var viewLat;		//where camera is looking
var viewLng;
var currentKmlObject = {'shelter' : null,'tsunami2' : null};		//used to show and hide kml
var currentClickedObject = {'name' : null, 'lat' : null, 'lng' : null};	//used to read from 
var currentLine = null;
directionsDisplay = new google.maps.DirectionsRenderer();
var nowAddress;
var routeButton;
var returnButton;
var cancelButton;
var appHint1; //アプリの説明
var appHint2;
var videoObj;



