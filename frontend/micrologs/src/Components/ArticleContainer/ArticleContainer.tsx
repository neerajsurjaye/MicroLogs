import ArticleCard from "../ArticleCard/ArticleCard";

type ArticleContainerProps = {
    className?: string;
};

const ArticleContainer = (props: ArticleContainerProps) => {
    const generateArticles = (articleCount: number, articleLength: number) => {
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

    return <div className={props.className}>{generateArticles(10, 100)}</div>;
};

export default ArticleContainer;
