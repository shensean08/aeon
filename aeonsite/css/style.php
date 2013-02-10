<?php header('Content-Type: text/css; charaset=utf-8'); ?>

@charset "UTF-8";
/* DPS */

<?php
	$aeoncolor = '#b42e83';
?>


ol,ul{list-style:none;}

blockquote,q{quotes:none;}

blockquote:before,blockquote:after,q:before,q:after{content:'';content:none;}
:focus {outline:0;}

ins{text-decoration:none;}

del{text-decoration:line-through;}

table{border-collapse:collapse;border-spacing:0;}

body{line-height:1;text-align:left;}

html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,font,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td{margin:0;padding:0;border:0;outline:0;font-size:100%;vertical-align:baseline;background:transparent;}




/* bg */

img.bg {
	text-align: right;
	min-height: 100%;
	min-width: 1024px;
	width: 100%;
	height: auto;
	position: fixed;
	top: 0;
	left: 0;
}

@media screen and (max-width: 1024px){
img.bg {
	left: 50%;
	margin-left: -512px; }
}

div#wrap {
	position: relative; 
}

div#main {
	background-color:rgba(255,255,255,0.6);
	width: 800px;
	height: 100%;
	margin: 0 auto;
	padding: 50px 0 75px 0;
}


/* common Start */

html {overflow-y:scroll;}

body {font: 0.8em "ヒラギノ角ゴ Pro W3", "Hiragino Kaku Gothic Pro", "メイリオ", Meiryo, Osaka, "ＭＳ Ｐゴシック", "MS PGothic", sans-serif; height: 100%; color: #111111; line-height: 1.7; word-wrap: break-word;}

article {
	width: 670px;
	margin: 0 auto;
}

.note {
	font-size: 0.9em;
}

h2{color: <?php echo $aeoncolor; ?>;
font-size: 125%;}

/* common End */

/* register Start */
table#register{
	width: 100%;
}

table#register th{font-weight: normal;}

table#register th.t-title{width: 100%; font-weight: bold; padding: 3em 0 2em 0; font-size: 110%;}

table#register td{padding: 0.7em 0; width: 37%;}

table#register input{margin: 0; padding: 0.1em 0; width:95%;}

table#register td.i-cap input{width:80%;margin-left: 0.5em;}
table#register td.i-cap2 input{width:auto;margin-right:0.5em}


/* register End */