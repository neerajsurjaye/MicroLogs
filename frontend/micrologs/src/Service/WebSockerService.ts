// type MessageHandler = (data: any) => void;

// class NotificationSocket {
//     private socket: WebSocket | null = null;
//     private handlers = new Set<MessageHandler>();
//     private userId: string | null = null;
//     private reconnectTimeout: number | null = null;

//     connect(userId: string) {
//         if (this.socket && this.socket.readyState === WebSocket.OPEN) return;

//         this.userId = userId;

//         this.socket = new WebSocket(
//             `ws://localhost:8080/ws/notifications?userId=${userId}`
//         );

//         this.socket.onopen = () => {
//             console.log("Notification socket connected");
//         };

//         this.socket.onmessage = (event) => {
//             try {
//                 const data = JSON.parse(event.data);
//                 this.handlers.forEach((h) => h(data));
//             } catch {
//                 console.warn("Invalid WS message", event.data);
//             }
//         };

//         this.socket.onclose = () => {
//             console.log("🔌 Notification socket closed");
//             this.socket = null;

//             // auto-reconnect
//             this.reconnectTimeout = window.setTimeout(() => {
//                 if (this.userId) {
//                     this.connect(this.userId);
//                 }
//             }, 3000);
//         };
//     }

//     disconnect() {
//         if (this.reconnectTimeout) {
//             clearTimeout(this.reconnectTimeout);
//         }
//         this.socket?.close();
//         this.socket = null;
//     }

//     subscribe(handler: MessageHandler) {
//         this.handlers.add(handler);
//     }

//     unsubscribe(handler: MessageHandler) {
//         this.handlers.delete(handler);
//     }
// }

// export const notificationSocket = new NotificationSocket();
