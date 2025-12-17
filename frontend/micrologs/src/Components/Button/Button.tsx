import "./button.css";

type labelledInputProps = {
    label: string;
    // state: string;
    // setState: React.Dispatch<React.SetStateAction<T>>;
    className?: string;
};

const Button = (props: labelledInputProps) => {
    return (
        <div className={"button outline " + props.className}>{props.label}</div>
    );
};

export default Button;
