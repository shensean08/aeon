<!doctype html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>HTML5 Webcam Test</title>
  </head>
  <script src="js/jquery.js" type="text/javascript"></script>
  <script type="text/javascript">
  	var video;
  	var canvas;
  	
  	function initCamera() {
  		video = document.getElementById('sourcevid');
  		navigator.getUserMedia = navigator.webkitGetUserMedia || navigator.getUserMedia; 
    	window.URL = window.URL || window.webkitURL;
    	
    	navigator.webkitGetUserMedia({video: true}, gotStream, noStream);
  	}
  	
  	function gotStream(stream) {
       if (window.URL) {
          video.src = window.URL.createObjectURL(stream);
       } else {
          video.src = stream; // Opera.
       }

       video.onerror = function(e) {
          stream.stop();
       };

       stream.onended = noStream;
    }

    function noStream(e) {
       console.log("Video capture error: ", error.code);
    }

	function snap() {
		canvas = document.getElementById("canvas").getContext("2d");
		canvas.drawImage(video, 20, 0, 300, 240);
	}
	
	function upload() {
		var imgData = document.getElementById("canvas").toDataURL("image/png");  
		imgData = imgData.replace('data:image/png;base64,', '');
		$.ajax({
				type: 'POST',
				url: 'loginQrAction',
				data: {'pic' : imgData},
		});
	}
  </script>
  <body onload="initCamera()">
    <video id="sourcevid" width="320" height="240" autoplay>Put your fallback message here.</video>
    <button id="snap" onclick="snap()">Snap Photo</button>
    <canvas id="canvas" width="320" height="240"></canvas>
    <button id="upload" onclick="upload()">upload</button>
	</textarea>
 </body>
</html>