window.onload = function() {
  drawCanvases();
};


function drawCanvases() {
  var utils = new Utils();
  drawCanvas_1();
  
  function drawCanvas_1() {
    var canvas = document.getElementById("canvas_logo");
    var ctx = canvas.getContext('2d');
    
    name();
    fancySquares();
    fancyStretch();
    
    function name() {
      ctx.shadowColor = "black";
      ctx.shadowOffsetX = 5; 
      ctx.shadowOffsetY = 5; 
      ctx.shadowBlur = 7;
      ctx.font = "40px 'Helvetica'";
      ctx.fillStyle = "red";
      ctx.textAlign = "center";
      ctx.fillText("Samuel Seidel", 150, 70);
      ctx.font = "20px 'Helvetica'";
      ctx.fil = "black";
      ctx.fillText("Portfolio", 150, 100);
      utils.clearShadows(ctx);
    }
    
    function fancySquares() {
      var style1 = "aqua",
          style2 = "purple";
      //a1();
      
      b1();
      a2();
      b2();
      a3();
      
      function a1() {
        ctx.fillStyle = style1;
        ctx.beginPath();
        ctx.rect(0, 0, 30, 30);
        ctx.rect(270, 0, 30, 30);
        ctx.rect(0, 100, 30, 30);
        ctx.rect(270, 100, 30, 30);
        ctx.fill();
      }
      function b1() {
        ctx.fillStyle = style2;
        ctx.beginPath(); ctx.arc(15,15,14,0,2*Math.PI);   ctx.fill();
        ctx.beginPath(); ctx.arc(285,15,14,0,2*Math.PI);  ctx.fill();
        ctx.beginPath(); ctx.arc(15,115,14,0,2*Math.PI);  ctx.fill();
        ctx.beginPath(); ctx.arc(285,115,14,0,2*Math.PI); ctx.fill();      
      }
      function a2() {
        ctx.fillStyle = style1;
        ctx.beginPath();
        ctx.rect(5, 5, 20, 20);
        ctx.rect(275, 5, 20, 20);
        ctx.rect(5, 105, 20, 20);
        ctx.rect(275, 105, 20, 20);
        ctx.fill();
      }
      function b2() {
        ctx.fillStyle = style2;
        ctx.beginPath(); ctx.arc(15,15,9,0,2*Math.PI);   ctx.fill();
        ctx.beginPath(); ctx.arc(285,15,9,0,2*Math.PI);  ctx.fill();
        ctx.beginPath(); ctx.arc(15,115,9,0,2*Math.PI);  ctx.fill();
        ctx.beginPath(); ctx.arc(285,115,9,0,2*Math.PI); ctx.fill();
      }
      function a3() {
        ctx.beginPath();
        ctx.rect(10, 10, 10, 10);
        ctx.rect(280, 10, 10, 10);
        ctx.rect(10, 110, 10, 10);
        ctx.rect(280, 110, 10, 10);
        ctx.fill();
      }
    }
    
    function fancyStretch() {
      topbottom();
      leftright();
      
      function topbottom() {
        ctx.fillStyle = 'purple';
        ctx.transform(12,0,0,1,-330,0);
        ctx.beginPath(); 
        ctx.arc(40,15,10,0,2*Math.PI);    
        ctx.arc(40,115,10,0,2*Math.PI);   
        ctx.fill();
        ctx.resetTransform();
      }
      function leftright() {
        ctx.fillStyle = 'blue';
        ctx.transform(1,0,0,6.6,0,-200);
        ctx.beginPath();
        ctx.arc(15,40,5,0,2*Math.PI);
        ctx.arc(285,40,5,0,2*Math.PI);
        ctx.fill();
        ctx.resetTransform();
      }
    }
    
    
  }
  
  function Utils() {
    this.clearShadows = function(ctx){
      ctx.shadowOffsetX = 0; 
      ctx.shadowOffsetY = 0; 
      ctx.shadowBlur = 0;
    };
  }
}
