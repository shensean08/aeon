//****************************************************************************/
// flyToOsaka
//
//****************************************************************************/
	

function flyToOsaka(){

ge.getOptions().setMouseNavigationEnabled(false);

		var lookat = ge.createLookAt('');

		//move to osaka
		lookat.set(34.7, 135.5,
			600, // altitude
			ge.ALTITUDE_RELATIVE_TO_GROUND,
			0, // heading
			30, // straight-down tilt
			120000 // range (inverse of zoom)
		);
		ge.getView().setAbstractView(lookat);
		

		setTimeout(function(){
			
			if (selectedPlace != null) {
				selectedPlace.dispose();
			}
			selectedPlace = new Place("現在地");
			selectedPlace.geocode("大阪府大阪市西区千代崎3丁目北2");
			selectedPlace.show();
			//loginButton.show();
			sideMenu.show();

			

		},5000);
	
		setTimeout(function(){
			ge.getOptions().setMouseNavigationEnabled(true);
			//alert('dragok');
		},7000);

}
