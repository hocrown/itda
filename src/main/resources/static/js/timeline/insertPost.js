/**
 * 
 */
$(document).ready(function(){

 	$(".headBox .gobackbtn").click(function(){
    location.href = "/familypost";
	});
	
	  $('#addImgPreview').on('click', function() {
    $('#addImgInput').click();
  });

  $('#addImgInput').change(function() {
    let reader = new FileReader();
    reader.onload = function(event) {
      let img = new Image();
      img.onload = function() {
        $('.innerAddImgBox img').attr('src', img.src);
        $('.innerAddImgBox img').show();
        $('.innerAddImgBox img').css({
          'position': 'absolute',
          'height': '100%',
          'cursor': 'pointer',
          'top': 'unset',
		  'left': 'unset'
        });
      }
      img.src = event.target.result;
    }
    reader.readAsDataURL(this.files[0]);
  });
});