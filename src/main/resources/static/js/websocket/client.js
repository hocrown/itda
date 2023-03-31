/**
 * 
 */
const notificationList = document.getElementById('notificationList');

// Replace with your WebSocket server URL
const socket = new WebSocket('ws://localhost:8080/notifications');

socket.addEventListener('open', (event) => {
  console.log('WebSocket connection opened:', event);
});

socket.addEventListener('message', (event) => {
  const notification = event.data;
  displayNotification(notification);
});

socket.addEventListener('close', (event) => {
  console.log('WebSocket connection closed:', event);
});

socket.addEventListener('error', (event) => {
  console.error('WebSocket error:', event);
});

function displayNotification(notification) {
  const listItem = document.createElement('li');
  listItem.textContent = notification;
  notificationList.appendChild(listItem);
}
