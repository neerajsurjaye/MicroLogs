import { GATEWAY_URL } from "../Constants/Constants";
import type { ArticleType } from "../Types/ArticleType";
import FetchService from "./FetchService";

class ArticleService {
    public static async fetchHomePage(): Promise<ArticleType[]> {
        const data = await FetchService.get(
            `${GATEWAY_URL}/article/api/v1/articles`,
            null
            // FetchService.getAuthHeader()
        );

        let articles: ArticleType[] = [];

        if (data?.data && data?.data?.map) {
            articles = data.data.map((x: any): ArticleType => {
                // let currArticle: ArticleType = {
                //     authorId: x.authorId,
                //     body: x.body,
                //     createdAt: x.createdAt,
                //     description: x.description,
                //     id: x.id,
                //     likeCount: x.likeCount,
                //     slug: x.slug,
                //     title: x.title,
                //     updatedAt: x.updatedAt,
                // };

                // return currArticle;
                return this.jsonToArticle(x);
            });
        } else {
            console.error("BAD ARTICLE DATA TYPE ", data);
        }

        return articles;
    }

    public static async fetchArticle(slug: string): Promise<ArticleType> {
        const data = await FetchService.get(
            `${GATEWAY_URL}/article/api/v1/articles/${slug}`,
            null
            // FetchService.getAuthHeader()
        );

        return this.jsonToArticle(data.data);
    }

    public static jsonToArticle(x: any): ArticleType {
        let currArticle: ArticleType = {
            authorId: x.authorId,
            body: x.body,
            createdAt: x.createdAt,
            description: x.description,
            id: x.id,
            likeCount: x.likeCount,
            slug: x.slug,
            title: x.title,
            updatedAt: x.updatedAt,
        };
        return currArticle;
    }

    public static async submitArticle(
        title: string,
        description: string,
        body: string,
        tagList: string[]
    ) {
        const postArticleUrl = `${GATEWAY_URL}/article/api/v1/articles`;
        const messageBody = { post: { title, description, body, tagList } };

        const resp = await FetchService.post(
            postArticleUrl,
            JSON.stringify(messageBody),
            FetchService.getAuthHeader()
        );

        return resp;
    }
}

export default ArticleService;
