import {Text, TextInput, StyleSheet, View, Button, Alert} from 'react-native';
import React, {useState} from 'react';
import {saveBudget} from '../store/budgetActons';
import {useDispatch} from 'react-redux';

export default function Entry({navigation, route}) {
  const budgetFromParams = route?.params?.budget;
  // const [item, setItem] = useState('');
  // const [plannedamount, setPlannedamount] = useState('');
  // const [actualamount, setActualAmount] = useState('');
  const [item, setItem] = useState(budgetFromParams?.item || '');
  const [plannedamount, setPlannedamount] = useState(
    budgetFromParams?.plannedamount || '',
  );
  const [actualamount, setActualAmount] = useState(
    budgetFromParams?.actualamount || '',
  );
  const dispatch = useDispatch();
  ``;

  const resetFormData = () => {
    setItem('');
    setPlannedamount('');
    setActualAmount('');
  };
  // const saveItem = async () => {
  //   const url = 'http://10.0.2.2:3000/user';
  //   let result = await fetch(url, {
  //     method: 'POST',
  //     headers: {
  //       'Content-Type': 'application/json',
  //     },
  //     body: JSON.stringify({item, plannedamount, actualamount}),
  //   });
  //   result = await result.json();
  //   if (result) {
  //     console.warn('Data added');
  //   }
  // };

  return (
    <View style={styles.viewstyle}>
      <Text style={styles.inputHeading}> Item</Text>

      <TextInput
        style={styles.textInput}
        placeholder="Enter the name of item"
        onChangeText={e => {        
          setItem(e);  
        }}
        value={item}
      />
      <Text style={styles.inputHeading}> Planned Amount</Text>
      <TextInput
        style={styles.textInput}
        keyboardType="number-pad"
        placeholder="Enter the Planned Amount"
        onChangeText={e => {
          setPlannedamount(e);
        }}
        value={plannedamount}
      />
      <Text style={styles.inputHeading}>Actual Amount</Text>
      <TextInput
        style={styles.textInput}
        keyboardType="number-pad"
        placeholder="Enter the Actual Amount"
        onChangeText={e => {
          setActualAmount(e);
        }}
        value={actualamount}
      />
      <View style={styles.buttonstyle}>
        <Button
          color={'green'}
          title="Save and View"
          onPress={() => {
            if (!item || !plannedamount || !actualamount) {
              alert('Please enter the details');
              return;
            }
              dispatch(saveBudget({item, plannedamount, actualamount}));
              console.log(saveBudget({item, plannedamount, actualamount}));
              alert('Budget Added');
              navigation.navigate('Budget Entry Listing')
              
            
          }}
        />
      </View>
      <View style={styles.buttonstyle}>
        <Button color={'pink'} title="Clear" onPress={resetFormData} />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  textInput: {
    fontSize: 16,
    height: 60,
    color: 'blue',
    borderWidth: 2,
    borderRadius: 10,
    borderColor: 'blue',
    margin: 10,
    marginBottom: 20,
    padding: 15,
    paddingLeft: 55,
    paddingRight: 55,
    textAlign: 'center',
  },
  inputHeading: {
    margin: 5,
    fontSize: 20,
    fontWeight: 'bold',
    marginBottom: 2,
    marginTop: 10,
    textAlign: 'center',
  },
  viewstyle: {
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 1,
  },
  buttonstyle: {
    marginBottom: 10,
    marginTop: 20,
  },
});
