
//****************************************************************************/
// Class PlaceBalloon
//
//****************************************************************************/
function PlaceBalloon(info,event) {

	var balloonDivInner_1 = '<table>'
		+ '<tr height="50">'
		+ '<td>'
		+ '<span class="placeBalloonText" style="padding-left:5px;font-weight:bold">addrMark</span><br>'
		//+ '<span class="placeBalloonText" style="padding-left:5px">海抜 Elevationｍ</span>'
		+ '</td>'
		+ '<td align="left" valign="top"><img style="max-width: 35px;max-height: 35px;padding-left:23px;" src = "' + URL_IMG + 'close_shelter-balloon-y.png" onclick="ge.setBalloon(null);">'
		+ '</td>'
		+ '</tr>'
		+ '<tr>'

		+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:40px; background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="toggleKml(\'tsunami2\');" >津波ハザードマップ</div>'
		//+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:40px; background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="selectedPlace.showNextBalloon();" >津波ハザードマップ</div>'
		+ '</td>'
		+ ''
		+ '</tr>'
		+ '<tr>'
		+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:40px; background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="toggleKml(\'shelter\');" >避難所の表示</div>'
		//+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:40px; background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="shelter.searchAndShow(0);" >近くの避難所</div>'

		+ '</td>'
		+ ''
		+ '</tr>'
		+ '<tr>'
		+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:30px; align:center;background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="download.download();" ><table style="height:30px" ><tr><td><img style="max-width: 23px;max-height: 23px; margin-top:6px;" src="' + URL_IMG + 'dl_shelter-balloon.png"></td><td valign="top" style="padding-top:3px">ダウンロード&nbsp;</td></tr></table></div>'
		+ '</td>'
		+ ''
		+ '</tr>'
		+ '</table>';

	var balloonDivInner_2 = '<table>'
		+ '<tr height="45">'
		+ '<td align="left" valign="top"><img style="max-width: 120px;max-height: 35px; padding-left:5px;" src = "' + URL_IMG + 'back_shelter-balloon-y.png"  onclick="selectedPlace.showPrevBalloon();">'
		+ '</td>'
		+ '<td align="left" valign="top"><img style="max-width: 35px;max-height: 35px;" src = "' + URL_IMG + 'close_shelter-balloon-y.png" onclick="ge.setBalloon(null);">'
		+ '</td>'
		+ '</tr>'
		+ '<tr>'
		+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:40px; background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="showTsunami(1);" >1mの津波</div>'
		+ '</td>'
		+ ''
		+ '</tr>'
		+ '<tr>'
		+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:40px; background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="showTsunami(2);" >3mの津波</div>'
		+ '</td>'
		+ ''
		+ '</tr>'
		+ '<tr>'
		+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:40px; background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="showTsunami(3);" >5mの津波</div>'
		+ '</td>'
		+ ''
		+ '</tr>'
		+ '<tr>'
		+ '<td colspan=2 align="center"><div style="width:130px;height:45px; line-height:30px; align:center;background-position:4px 1px;background-image:url(' + URL_IMG + 'btn_shelter-balloon-y_1.png' + '); background-repeat:no-repeat; color:white; font-size:12px;"  onclick="download.download();" ><table style="height:30px" ><tr><td><img style="max-width: 23px;max-height: 23px; margin-top:6px;" src="' + URL_IMG + 'dl_shelter-balloon.png"></td><td valign="top" style="padding-top:3px">ダウンロード&nbsp;</td></tr></table></div>'
		+ '</td>'
		+ ''
		+ '</tr>'
		+ '</table>';
	this.prevDivInner;

	this.placeMarkBalloon = ge.createHtmlDivBalloon('');
	this.placeMarkBalloon.setFeature(event.getTarget());
	this.placeMarkBalloon.setMaxWidth(500);
	this.placeMarkBalloon.setCloseButtonEnabled(false);

	this.balloonDiv = document.createElement('DIV');
	this.balloonDiv.innerHTML = balloonDivInner_1.replace("addrMark", info.name).replace("Elevation",info.elevation);

	this.placeMarkBalloon.setContentDiv(this.balloonDiv);


	// show Place Balloon
	//
	PlaceBalloon.prototype.show = function() {
		ge.setBalloon(this.placeMarkBalloon);
	};

	// show Next Menu
	//
	PlaceBalloon.prototype.showNext = function(){
		this.prevDivInner = this.balloonDiv.innerHTML;
		this.balloonDiv.innerHTML = balloonDivInner_2;
	};

	// show Prev Menu
	//
	PlaceBalloon.prototype.showPrev = function(){
		this.balloonDiv.innerHTML = this.prevDivInner;
	};

	return this;
}

