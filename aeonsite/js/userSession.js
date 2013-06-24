//****************************************************************************/
// Class User Session
//
//****************************************************************************/
function UserSession() {

	var userInfo = null;		//JSON String
	var userQRCode = null;
	var result = null;

	//Request UserInfo through call WEB API
	//
	UserSession.prototype.requestUserInfo = function(QRCode,callback) {

		var qrUrl = USERINFO_URL + QRCode;

		//alert("in usersession");
		//alert(qrUrl);
		//alert(USERINFO_URL + QRCode);
		//alert("result1=" + result);
/*
		$.ajax({
			datatype: "post",
			url: qrUrl,
			data: result,
			success: function(){
				alert("success");
				$("#result").html('submitted successfully');
			},
			error: function(){
				alert("error");
				$("#result").html('there was an error while submitting');
			}
		});



		var foo = $.getJSON(USERINFO_URL + QRCode,function(result){
			alert("resul2t=" + result);
			userInfo = result;
			userQRCode = QRCode;
			console.log("success");
			callback();
		})
		.done(function(result){console.log("second success");})
		.fail(function(result){console.log("error");})
		.always(function(result){console.log("complete");});
		foo.complete(function(result) {console.log("second complete");});

		alert("result3=" + result);
		*/

		$.getJSON(qrUrl, {} ,function(data){
			//alert(USERINFO_URL + QRCode + '&Callback=?');
			//alert(data);
			//alert(status);
			userInfo = data;
			userQRCode = QRCode;
			callback();

		});
	};
	//get user QRCode
	//
	UserSession.prototype.getQRCode = function() {
		return userQRCode;
	};
		/*
		$.each(result.places,function(i, place) {
			alert(place.name);
			alert(place.address);
		});
		*/

	//get place count
	//
	UserSession.prototype.placeCount = function() {
		return userInfo.places.length;
	};

	//get PlaceName
	//
	UserSession.prototype.getPlaceName = function(idx) {
		return userInfo.places[idx].name;
	};

	//get Address
	//
	UserSession.prototype.getAddress = function(idx) {
		return userInfo.places[idx].address;
	};

	//login out
	//
	UserSession.prototype.loginOut = function() {

		if (selectedPlace != null) {
		selectedPlace.dispose();
		}
		if (placeSelectMenu != null) {
			placeSelectMenu.dispose();
		}

		userInfo = null;

		userQRCode = null;
	};
	//is Login in
	//
	UserSession.prototype.isLoginIn = function() {


		if (userQRCode == null) {

			return false;

		}

	return true;

	};


	// authenticate


		//


	UserSession.prototype.authenticate = function(QRCode) {


		if (userQRCode == QRCode) {

			return true;

		}

		return false;
	};
	return this;
}


