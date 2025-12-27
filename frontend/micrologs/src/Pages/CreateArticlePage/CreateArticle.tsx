import { useState } from "react";
import LabelledInput from "../../Components/LabelledInput/LabelledInput";
import "./createArticle.css";

const CreateArticle = () => {
    const [title, setTitle] = useState("");

    return (
        <div className="layout create-article-page">
            <div className="layout-left outline"></div>
            <div className="layout-center outline">
                <div className="create-article  outline">
                    <h1>Create Article</h1>
                    <form>
                        <LabelledInput<string>
                            label="Title"
                            state={title}
                            setState={setTitle}
                            className="article-title-input"
                        ></LabelledInput>

                        <div className="article-desc-input">
                            <span>Content : </span>
                            <textarea name="text-area" id="article"></textarea>
                        </div>

                        <div className="article-submit-btn">
                            <input
                                className="btn"
                                type="button"
                                value={"Submit Article"}
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
