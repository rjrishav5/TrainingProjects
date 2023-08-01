import React, {useEffect, useState} from 'react';
import {Text, View, FlatList, StyleSheet} from 'react-native';
import { useSelector } from 'react-redux';
import store from '../store/store';





const BudgetList = () => {
  // const [data, setData] = useState([]);
  // const getAPIData = async () => {
  //   const url = 'http://10.0.2.2:3000/user';
  //   const result = await fetch(url);
  //   let result1 = await result.json();
  //   if (result1) {
  //     setData(result1);
  //   }
  // };
  // useEffect(() => {
  //   getAPIData();
  // });
  const {budgets} = useSelector(store => store.budgetReducer);

  return (
    <View style={{flex: 1}}>
      <View style={styles.heading}>
        <Text>Name of Item</Text>
        <Text> Planned Amount</Text>
        <Text>Actual Amount</Text>
      </View>
      
        <FlatList
          data={budgets}
          renderItem={({item}) => (
            <View style={styles.list}>
              <Text>{item.item}</Text>
              <Text>{item.plannedamount}</Text>
              <Text>{item.actualamount}</Text>
            </View>
          )}
        />
     
    </View>
  );
};
const styles = StyleSheet.create({
  list: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'space-around',
    backgroundColor: 'pink',
    margin: 5,
    padding: 5,
    textAlign: 'center',
  },
  heading: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    flex: 0.05,
    textAlign: 'center',
    backgroundColor: 'green',
  },
});

export default BudgetList;
