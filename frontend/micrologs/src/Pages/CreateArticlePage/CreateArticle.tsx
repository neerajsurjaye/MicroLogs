import { use, useState } from "react";
import LabelledInput from "../../Components/LabelledInput/LabelledInput";
import "./createArticle.css";
import ArticleService from "../../Service/ArticleService";

const CreateArticle = () => {
    const [title, setTitle] = useState("");
    const [desc, setDesc] = useState("");
    const [body, setBody] = useState("");
    const [tagList, setTagList] = useState("");

    const submitArticle = async () => {
        const resp = await ArticleService.submitArticle(
            title,
            desc,
            body,
            tagList.split(",")
        );

        console.log("Article submitted with response :: ", resp);
    };

    return (
        <div className="layout create-article-page">
            <div className="layout-left outline"></div>
            <div className="layout-center outline">
                <div className="create-article  outline">
                    <h1>Create Article</h1>
                    <form>
                        <LabelledInput
                            label="Title"
                            state={title}
                            setState={setTitle}
                            className="article-title-input"
                        ></LabelledInput>

                        <LabelledInput
                            label="description"
                            state={desc}
                            setState={setDesc}
                        ></LabelledInput>

                        <div className="article-desc-input">
                            <span>Content : </span>
                            <textarea
                                name="text-area"
                                id="article"
                                value={body}
                                onChange={(e) => {
                                    setBody(e.target.value);
                                }}
                            ></textarea>
                        </div>

                        <LabelledInput
                            label="Tags"
                            state={tagList}
                            setState={setTagList}
                        ></LabelledInput>

                        <div className="article-submit-btn">
                            <input
                                className="btn"
                                type="button"
                                value={"Submit Article"}
                                onClick={submitArticle}
                            />
                        </div>
                    </form>
                </div>
            </div>

            <div className="layout-right outline"></div>
        </div>
    );
};

export default CreateArticle;
