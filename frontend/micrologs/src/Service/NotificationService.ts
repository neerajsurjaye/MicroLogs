import { GATEWAY_URL } from "../Constants/Constants";
import FetchService from "./FetchService";

class NotificationService {
    public static async getNotificationForUser(userid: string) {
        console.log(
            "Hitting for logs : ",
            `${GATEWAY_URL}/notification/api/v1/notification/${userid}`
        );

        const resp = await FetchService.get(
            `${GATEWAY_URL}/notification/api/v1/notification/${userid}`,
            FetchService.getAuthHeader()
        );

        console.log(resp.notifications);

        return resp.notifications;
    }
}

export default NotificationService;
