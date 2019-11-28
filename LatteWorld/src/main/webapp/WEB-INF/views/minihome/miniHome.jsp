<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
   .skinArea{
      position:relative;
      width: 1420px;
      height: 850px;
      background: black;
   }
   
   .homepyArea{
      position:relative; 
      top:55px; 
      left:50px;
      width: 1050px;
      height: 730px;
      background: yellow;
      float: left;
   }
   
   .menuArea{
      position: absolute;
      top: 130px;
      left: 1100px;
      width: 100px;
      height: 150px;
      background: #FFD8D8;
   }
   
   .top-content{
      position: absolute;
      top:0px;
      left: 0px;
      width: 1050px;
      height: 65px;
      background: pink;
   }
   
    .center-content{
      position: relative;
      top:65px;
      left: 0px;
      width: 1050px;
      height: 665px;
   } 
   
   .contentsub{
      position: relative;
      top: 0px;
      left: 0px;
      width: 280px;
      height: 665px;
      background: green;
      float: left;
   }
   
   .contentMain{
      position: relative;
      top: 0px;
      left: 280px;
      width: 770px;
      height: 665px;
      background: #E8D9FF;
   }
   
   .menuBtn{
      width: 100px;
      height: 30px;
   }
   
   .another-content{
         display: none;
   }
   
   .today{
       position: absolute;
       top: 0px;
       left: 0px;
       width: 280px;
       height: 65px;
       background: white;
   }
   
   .homepy-title{
       position: absolute;
       top: 0px;
       left: 280px;
       width: 770px;
       height: 65px;
       background: skyblue;
   }
   
</style>
</head>
<body>
   <div class="skinArea">
      <div class="homepyArea">
         <div class="top-content">
            <div class="today">투데이</div>
            <div class="homepy-title">${UserInfo.userName }님의 미니홈피</div>
         </div>
           <div id="content1" class="center-content">
            <div class="contentsub">프로필</div>
            <div class="contentMain">메인</div>
         </div> 
         <div id="content2" class="center-content another-content">
            <div class="contentsub">다이어리메뉴</div>
            <div class="contentMain">다이어리</div>
         </div>
          <div id="content3" class="center-content another-content">
            <div class="contentsub">사진첩메뉴</div>
            <div class="contentMain">사진첩</div>
         </div>
         <div id="content4" class="center-content another-content">
            <div class="contentsub">게시판메뉴</div>
            <div class="contentMain">게시판</div>
         </div>
          <div id="content5" class="center-content another-content">
            <div class="contentsub">프로필</div>
            <div class="contentMain">방명록</div>
         </div> 
      </div>
      <div class="menuArea">
         <button id="menuBtn1" class="menuBtn">홈</button>
         <button id="menuBtn2" class="menuBtn">다이어리</button>
         <button id="menuBtn3" class="menuBtn">사진첩</button>
         <button id="menuBtn4" class="menuBtn">게시판</button>
         <button id="menuBtn5" class="menuBtn">방명록</button>
      </div>
   </div>
   
   <script type="text/javascript">
   
            $("#menuBtn1").click(function(){
               $("#content1").show();
               $("#content2").hide();
               $("#content3").hide();
               $("#content4").hide();
               $("#content5").hide();
            });
            
            $("#menuBtn2").click(function(){
               $("#content1").hide();
               $("#content2").show();
               $("#content3").hide();
               $("#content4").hide();
               $("#content5").hide();
            });
            
            $("#menuBtn3").click(function(){
               $("#content1").hide();
               $("#content2").hide();
               $("#content3").show();
               $("#content4").hide();
               $("#content5").hide();
            });
            
            $("#menuBtn4").click(function(){
               $("#content1").hide();
               $("#content2").hide();
               $("#content3").hide();
               $("#content4").show();
               $("#content5").hide();
            });
            
            $("#menuBtn5").click(function(){
               $("#content1").hide();
               $("#content2").hide();
               $("#content3").hide();
               $("#content4").hide();
               $("#content5").show();
            });
   </script>
</body>
</html>