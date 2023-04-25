/**
 * 
 */
 $(document).ready(function() {
 	$(".headBox .vector").click(function(){
    location.href = "/dailymain";	
	});
	
	const prevMonthBtn = $('#prevMonth');
	const nextMonthBtn = $('#nextMonth');
	const monthText = $('.monthText');
	const yearText = $('.yearText');
	const stickerContainer = $('.stickerContainer');
	const backgroundImg = $('.layout img[src^="/image/monthly/backImg"]');

	const currentDate = new Date();
	let currentYear = currentDate.getFullYear();
	let currentMonth = currentDate.getMonth() + 1;
	console.log(currentMonth);
	monthText.text(`${currentMonth}월`);
	
	changeMonthData(currentYear, currentMonth);
	

	prevMonthBtn.on('click', function () {
		 if (currentMonth === 1) {
	    if (currentYear > 1) {
	      currentYear--;
	      currentMonth = 12;
	    } else {
	      return;
	    }
	  } else {
	    currentMonth--;
	  }
	  changeMonthData(currentYear, currentMonth);
	});

	nextMonthBtn.on('click', function () {
		 if (currentMonth === 12) {
	    currentYear++;
	    currentMonth = 1;
	  } else {
	    currentMonth++;
	  }
	  changeMonthData(currentYear, currentMonth);
	});
	
	
  function changeMonthData(year, month) {
	yearText.text(`${year}`);
    monthText.text(`${month}월`);
	changeStickerStylesheet(month);

    $.ajax({
      url: `/monthly/getmonth`,
      type: 'POST',
      dataType: 'json',
      data:{
		  year: year,
		  month: month
	  },
     success: function (data) {
      stickerContainer.empty();
      console.log(data.stickersCount);
      backgroundImg.attr('src', `/image/monthly/backImg${String(month).padStart(2, '0')}.png`);
      backgroundImg.addClass('imgScale');
      for (let i = 1; i <= data.stickersCount; i++) {
        const newImage = $('<img>');
        newImage.attr('src', `/image/monthly/sticker${String(month).padStart(2, '0')}.png`);
        newImage.addClass(`sticker${String(month).padStart(2, '0')}-${i}`);
        newImage.addClass(`stickerImgScale`);

        stickerContainer.append(newImage);
      }
    },
      error: function (err) {
        console.error('Error fetching data:', err);
      },
    });
  }
  
  	function changeStickerStylesheet(month) {
  	const stickerStylesheet = document.getElementById('stickerStylesheet');
  	stickerStylesheet.href = `/css/dailyquestion/sticker/sticker${month}.css`;
	}
});



	