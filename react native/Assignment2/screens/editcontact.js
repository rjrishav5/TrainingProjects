import {
  View,
  Text,
  StyleSheet,
  TextInput,
  TouchableOpacity,
  Alert,
} from 'react-native';
import React, {useEffect, useState} from 'react';
import {openDatabase} from 'react-native-sqlite-storage';
import {useNavigation, useRoute} from '@react-navigation/native';
let db = openDatabase({name: 'UserDatabase.db'});

const EditContact = () => {
   const route = useRoute();
  
  console.log(route.params.data);
  const navigation = useNavigation();
  const [Name, setName] = useState(name);
  const [number, setLnumber] = useState(route.params.data.lnumber);

  const updateContact = () => {
    db.transaction(tx => {
      tx.executeSql(
        'UPDATE contacts set name=?, lnumber=?  where pnumber=?',
        [name, lnumber, route.params.data.pnumber],
        (tx, results) => {
          console.log('Results', results.rowsAffected);
          if (results.rowsAffected > 0) {
            Alert.alert(
              'Success',
              'contact updated successfully',
              [
                {
                  text: 'Ok',
                  onPress: () => navigation.navigate('contactlist'),
                },
              ],
              {cancelable: false},
            );
          } else alert('Updation Failed');
        },
      );
    });
  };
  useEffect(() => {
    setName(route.params.data.name);
    setLnumber(route.params.data.email);
  }, []);

  return (
    <View style={styles.container}>
      <TextInput
        placeholder="Enter User Name"
        style={styles.input}
        value={name}
        onChangeText={txt => setName(txt)}
      />
      <TextInput
        placeholder="Enter User Email"
        value={email}
        onChangeText={txt => setLnumber(txt)}
        style={[styles.input, {marginTop: 20}]}
      />
      <TouchableOpacity
        style={styles.addBtn}
        onPress={() => {
          updateContact();
        }}>
        <Text style={styles.btnText}>Save Contact</Text>
      </TouchableOpacity>
    </View>
  );
};
export default EditContact;
const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  input: {
    width: '80%',
    height: 50,
    borderRadius: 10,
    borderWidth: 0.3,
    alignSelf: 'center',
    paddingLeft: 20,
    marginTop: 100,
  },
  addBtn: {
    backgroundColor: 'purple',
    width: '80%',
    height: 50,
    borderRadius: 10,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 30,
    alignSelf: 'center',
  },
  btnText: {
    color: '#fff',
    fontSize: 18,
  },
});
