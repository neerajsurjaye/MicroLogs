import type { ArticleType } from "../../Types/ArticleType";
import ArticleCard from "../ArticleCard/ArticleCard";
import "./articleContainer.css";

type ArticleContainerProps = {
    className?: string;
    article?: ArticleType[];
};

const ArticleContainer = (props: ArticleContainerProps) => {
    const generateDummyArticles = (
        articleCount: number,
        articleLength: number
    ) => {
        const articles: React.ReactElement[] = [];

        const words = [
            "apple",
            "river",
            "cloud",
            "engine",
            "shadow",
            "pixel",
            "forest",
            "signal",
            "quantum",
            "ember",
        ];

        const users = ["john", "doe", "adam", "joey"];

        for (let i: number = 0; i < articleCount; i++) {
            const articleContent: string[] = [];

            for (let i: number = 0; i < articleLength; i++) {
                articleContent.push(
                    words[Math.floor(Math.random() * words.length)]
                );
            }

            const user = users[Math.floor(Math.random() * users.length)];
            const content = articleContent.join(" ");
            const likes = Math.floor(Math.random() * 100);
            const dislikes = Math.floor(Math.random() * 100);
            const title = articleContent
                .join(" ")
                .slice(0, Math.ceil(articleLength / 10));

            articles.push(
                <ArticleCard
                    user={user}
                    desc={content}
                    likes={likes}
                    dislikes={dislikes}
                    title={title}
                ></ArticleCard>
            );
        }

        return articles;
    };

    const generateArticles = () => {
        const articles: React.ReactElement[] = [];

        if (!props.article) {
            return;
        }

        props.article.map((x) => {
            console.log(x.authorId);

            articles.push(
                <ArticleCard
                    user={"" + x.authorId}
                    desc={x.description}
                    likes={x.likeCount}
                    title={x.title}
                    key={x.id}
                    slug={x.slug}
                ></ArticleCard>
            );
        });

        return articles;
    };

    if (props.article == null) {
        return (
            <div className={"article-container " + props.className}>
                ###Dummy articles
                {generateDummyArticles(10, 100)}
            </div>
        );
    }

    return (
        <div className={"article-container " + props.className}>
            {generateArticles()}
        </div>
    );
};

export default ArticleContainer;
