import {SAVE_BUDGET, DELETE_BUDGET, UPDATE_BUDGET} from './budgetActons';

const initialState = {
  budgets: [],
};
const budgetReducer = (state = initialState, action) => {
  const {type, payload} = action || {};
  const newBudgets = [...state.budgets];

  switch (type) {
    case SAVE_BUDGET:
      return {
        ...state,
        budgets: [...state.budgets, payload],
      };
    case DELETE_BUDGET:
      const index = newBudgets.findIndex(budget => budget.name === payload);
      const newArray = newBudgets.filter((item, idx) => idx !== index);
      return {
        ...state,
        budgets: newArray,
      };
    case UPDATE_BUDGET:
      const bgtIndx = newBudgets.findIndex(
        budget => budget.name === payload.name,
      );
      newBudgets[bgtIndx] = payload;
      return {
        ...state,
        budgets: newBudgets,
      };
    default:
      return state;
  }
};
export default budgetReducer;
