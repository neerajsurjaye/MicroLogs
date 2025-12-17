import "./labelledInput.css";

type labelledInputProps<T> = {
    label: string;
    state: T;
    setState: React.Dispatch<React.SetStateAction<T>>;
    className?: string;
};

const LabelledInput = <T,>(props: labelledInputProps<T>) => {
    return (
        <div className={"labelled-input outline " + props.label}>
            <label>{props.label}</label>
            <input></input>
        </div>
    );
};

export default LabelledInput;
