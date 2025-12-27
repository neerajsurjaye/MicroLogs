import { Client } from "@stomp/stompjs";
import SockJS from "sockjs-client/dist/sockjs";

import {
    WEB_SOCKET_NOTIFICATION_ENDPOINT,
    WEB_SOCKET_API_ENDPOINT,
} from "../Constants/WebSocketConstnts";

type MessageHandler = (data: any) => void;

class WebSocketService {
    private client: Client | null = null;
    private handlers: Set<MessageHandler> = new Set();

    connect() {
        if (this.client?.active) return;

        this.client = new Client({
            webSocketFactory: () => new SockJS(WEB_SOCKET_API_ENDPOINT),
            reconnectDelay: 5000,

            onConnect: () => {
                console.log("WS connected");

                this.client?.subscribe(
                    WEB_SOCKET_NOTIFICATION_ENDPOINT,
                    (message) => {
                        const data = JSON.parse(message.body);
                        this.handlers.forEach((h) => h(data));
                    }
                );
            },
            debug: (str) => console.log(str),
        });

        this.client.activate();
    }

    disconnect() {
        this.client?.deactivate();
        this.client = null;
    }

    subscribe(handler: MessageHandler) {
        this.handlers.add(handler);
    }

    unsubscribe(handler: MessageHandler) {
        this.handlers.delete(handler);
    }
}

export const webSocketService = new WebSocketService();
