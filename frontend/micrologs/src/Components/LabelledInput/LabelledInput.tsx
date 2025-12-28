import "./labelledInput.css";

type labelledInputProps = {
    label: string;
    state: string;
    setState: React.Dispatch<React.SetStateAction<string>>;
    className?: string;
};

const LabelledInput = (props: labelledInputProps) => {
    return (
        <div className={"labelled-input outline " + props.label}>
            <label>{props.label}</label>:{" "}
            <input
                value={props.state}
                onChange={(e) => {
                    props.setState(e.target.value);
                }}
            ></input>
        </div>
    );
};

export default LabelledInput;
