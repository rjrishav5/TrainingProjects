import React, {Component} from 'react';

import {StyleSheet, Text, ToastAndroid, View} from 'react-native';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import Entry from './screen/entry';
import BudgetList from './screen/budgetlist';
import 'react-native-gesture-handler';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import globalstore from './store/store';
import {Provider} from 'react-redux';

const Stack = createStackNavigator();
const Tab = createBottomTabNavigator();
const App = () => {
  return (
    <Provider store={globalstore}>
      <View style={{flex: 1}}>
        <Text style={styles.heading}>Home Budget</Text>

        <NavigationContainer>
          <Stack.Navigator
            screenOptions={{
              headerStyle: {
                backgroundColor: 'skyblue',
              },
              headerTintColor: 'red',
              headerTitleAlign: 'center',
            }}>
            <Stack.Screen name="Budget Entry" component={Entry} />
            <Stack.Screen name="Budget Entry Listing" component={BudgetList} />
          </Stack.Navigator>
        </NavigationContainer>
      </View>
    </Provider>
  );
};
const styles = StyleSheet.create({
  heading: {
    fontSize: 28,
    textAlign: 'center',
    padding: 30,
    backgroundColor: 'orange',
    paddingLeft: 65,
    paddingRight: 55,
    marginVertical: 5,
    borderWidth: 2,
    borderRadius: 16,
  },
});

//<NavigationContainer>
//    <Stack.Navigator initialRouteName = "entry">
//     <Stack.Screen name= "entry" component={Entry}/>
//   <Stack.Screen name = "budgetlist" component={BudgetList}/>
//</Stack.Navigator>
//</NavigationContainer>

export default App;
