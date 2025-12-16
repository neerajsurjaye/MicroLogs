import ArticleCard from "../ArticleCard/ArticleCard";

type ArticleContainerProps = {
    className: string;
};

const ArticleContainer = (props: ArticleContainerProps) => {
    return (
        <div className={props.className}>
            <ArticleCard></ArticleCard>
            <ArticleCard></ArticleCard>
            <ArticleCard></ArticleCard>
            <ArticleCard></ArticleCard>
            <ArticleCard></ArticleCard>
        </div>
    );
};

export default ArticleContainer;
