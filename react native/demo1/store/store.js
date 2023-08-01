import {createStore, combineReducers} from 'redux';

import budgetReducer from './budgetReducer';

const rootReducer = combineReducers({
  budgetReducer
});

const store = createStore(rootReducer);

export default store;
