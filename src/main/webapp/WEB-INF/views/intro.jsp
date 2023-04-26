<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="noErrorHead.jsp"%>
<style>
  .carousel-container {
    position: relative;
    width: 393.33px;
    height: 851.33px;
    overflow: hidden;
    white-space: nowrap;
    scroll-snap-type: x mandatory;
  }

  .carousel-slide {
    display: inline-block;
    width: 393.33px;
    height: 851.33px;
    vertical-align: top;
    scroll-snap-align: start;
  }
</style>
</head>
<body>
<div class="carousel-container">
  <img class="carousel-slide" src="../image/intro/intro1.png" alt="Slide 1">
  <img class="carousel-slide" src="../image/intro/intro2.png" alt="Slide 2">
  <img class="carousel-slide" src="../image/intro/intro3.png" alt="Slide 3">
  <img class="carousel-slide" src="../image/intro/intro4.png" alt="Slide 4">
  <img class="carousel-slide" src="../image/intro/intro5.png" alt="Slide 5">
  <img class="carousel-slide" src="../image/intro/intro6.png" alt="Slide 6">
  <img class="carousel-slide" src="../image/intro/intro7.png" alt="Slide 7">    
</div>

<script>
  let startX;
  let endX;
  let offsetX;
  const carouselContainer = document.querySelector('.carousel-container');
  const slideWidth = 393.33;

  carouselContainer.addEventListener('touchstart', (event) => {
    startX = event.touches[0].clientX;
    carouselContainer.style.transition = ''; // 초기화
  });

  carouselContainer.addEventListener('touchmove', (event) => {
    endX = event.touches[0].clientX;
    offsetX = startX - endX;
    carouselContainer.scrollBy(offsetX, 0);
    startX = endX;
  });

  carouselContainer.addEventListener('touchend', () => {
    let currentScroll = carouselContainer.scrollLeft;
    let currentPage = Math.round(currentScroll / slideWidth);

    if (offsetX > 50) {
      currentPage += 1;
    } else if (offsetX < -50) {
      currentPage -= 1;
    }

    carouselContainer.style.transition = 'scroll-left 300ms';
    carouselContainer.scrollTo({ left: currentPage * slideWidth, behavior: 'smooth' });
  });
</script>
</body>
</html>