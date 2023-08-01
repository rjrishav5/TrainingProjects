export const SAVE_BUDGET = 'SAVE_BUDGET';
export const DELETE_BUDGET = 'DELETE_BUDGET';
export const UPDATE_BUDGET = 'UPDATE_BUDGET';

export function saveBudget(budget) {
  return {
    type: SAVE_BUDGET,
    payload: budget,
  };
}

export function updateBudget(budget) {
  return {
    type: UPDATE_BUDGET,
    payload: budget,
  };
}

export function deleteBudget(budgetName) {
  return {
    type: DELETE_BUDGET,
    payload: budgetName,
  };
}
