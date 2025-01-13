import { useState } from 'react';
import CounterButton from './CounterButton'
import './Counter.css'
import ResetButton from './ResetButton';


export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterFunctionParent(by) {
        setCount(count + by);
    }
    function decrementCounterFunctionParent(by) {
        setCount(count - by);
    }
    function resetCountFunction(){
        setCount(0);
    }
    return (
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} incrementMethod={incrementCounterFunctionParent} decrementMethod={decrementCounterFunctionParent} />
            <CounterButton by={3} incrementMethod={incrementCounterFunctionParent} decrementMethod={decrementCounterFunctionParent} />
            <CounterButton by={5} incrementMethod={incrementCounterFunctionParent} decrementMethod={decrementCounterFunctionParent} />
            <ResetButton resetMethod = {resetCountFunction}/>
        </>
    )
}
