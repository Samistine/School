window.onload = function() {
  drawCanvases();
};


function drawCanvases() {
  drawCanvas();
  
  function drawCanvas() {
    var canvas = document.getElementById("canvas_logo");
    var ctx = canvas.getContext('2d');
    
    ctx.shadowColor = "white";
    ctx.shadowOffsetX = 5; 
    ctx.shadowOffsetY = 5; 
    ctx.shadowBlur = 7;
    ctx.font = "40px 'Helvetica'";
    ctx.fillStyle = "white";
    ctx.textAlign = "center";
    ctx.fillText("Samuel Seidel", 150, 70);
    ctx.font = "20px 'Helvetica'";
    ctx.fillText("Portfolio", 150, 100);
  }
}
