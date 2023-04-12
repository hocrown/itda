/**
 * 
 */
const alarmList = document.getElementById('alarmList');
const socketUrl = window.location.origin + '/ws';

// Check if SockJS and STOMP are supported by the browser
if ('SockJS' in window && 'Stomp' in window) {
  const socket = new SockJS(socketUrl);
  const stompClient = Stomp.over(socket);
  
  stompClient.connect({}, (frame) => {
    console.log('WebSocket connection opened:', frame);
    // Get userId from session storage
    const userId = sessionStorage.getItem('userId');
    // Subscribe to /user/{userId}/queue/alarm
    stompClient.subscribe('/user/' + userId + '/queue/alarm', (response) => {
      const alarm = response.body;
      displayAlarm(alarm);
    });
  });
} else {
  console.error('SockJS and/or STOMP not supported by the browser');
}

function displayAlarm(alarm) {
  const listItem = document.createElement('li');
  listItem.textContent = alarm;
  alarmList.appendChild(listItem);
  console.log(alarm);
}
