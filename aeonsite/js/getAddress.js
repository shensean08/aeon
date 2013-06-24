//****************************************************************************/
// Getting latlng of place where camera is looking
//
//****************************************************************************/
function viewEventListener(event) {
  var lookAt = ge.getView().copyAsLookAt(ge.ALTITUDE_RELATIVE_TO_GROUND);
	//document.getElementById("id_lat_la").innerHTML = lookAt.getLatitude().toFixed(10);
	//document.getElementById("id_lng_la").innerHTML = lookAt.getLongitude().toFixed(10);
	viewLat = lookAt.getLatitude();
	viewLng = lookAt.getLongitude();
}

//****************************************************************************/
// Class getAddress
//
//****************************************************************************/

	function getAddress(lat1,lng1) {
		var geocoder = new google.maps.Geocoder();
		var latlngmap = new google.maps.LatLng(lat1,lng1);
		geocoder.geocode({
			latLng: latlngmap
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				if (results[0].geometry) {
					var address = results[0].formatted_address.replace(/^日本, /, '');
					alert(address);
					nowAddress = address; /////////////////////////////////かえる
				}
			}
		});
	}

