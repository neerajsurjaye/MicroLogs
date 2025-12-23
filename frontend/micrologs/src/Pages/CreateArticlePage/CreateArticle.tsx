import "./createArticle.css";

const CreateArticle = () => {
    return (
        <div className="create-article layout outline">
            <div className="layout-left outline"></div>
            <div className="layout-center outline">
                <h1>Create Article</h1>
                <form>
                    <div className="article-title-input">
                        <span>Title</span>
                        <input type="text" />
                    </div>

                    <div className="article-desc-input">
                        <span>Content</span>
                        <input type="text"></input>
                    </div>

                    <div className="article-submit-btn">
                        <input type="button" value={"Submit Article"} />
                    </div>
                </form>
            </div>
            <div className="layout-right outline"></div>
        </div>
    );
};

export default CreateArticle;
