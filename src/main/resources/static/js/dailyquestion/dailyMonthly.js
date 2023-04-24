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
	const stickerContainer = $('.stickerContainer .backgroundImg');
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
    monthText.text(`${month}월`);

    console.log(month);

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
		backgroundImg.attr('src', `/image/monthly/backImg${String(month).padStart(2, '0')}.png`);
        for (let i = 1; i <= data.stickersCount; i++) {
          const newImage = $('<img>');
          newImage.attr('src', `/image/monthly/sticker${String(month).padStart(2, '0')}.png`);
          newImage.addClass(`sticker${String(month).padStart(2, '0')}-${i}`);
          stickerContainer.append(newImage);
        }
      },
      error: function (err) {
        console.error('Error fetching data:', err);
      },
    });
  }
});



	