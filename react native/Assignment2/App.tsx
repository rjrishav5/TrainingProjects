import React from 'react';
import type {PropsWithChildren} from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import ContactList from './screens/contactlist';
import AddContact from './screens/addcontact';
import {createMaterialTopTabNavigator} from '@react-navigation/material-top-tabs';
import {NavigationContainer} from '@react-navigation/native';
import EditContact from './screens/editcontact';

const Tab = createMaterialTopTabNavigator();
const App = () => {
  return (
    <View style={{flex: 1}}>
      <Text style={styles.heading}>Contacts</Text>
      <NavigationContainer>
        <Tab.Navigator>
          <Tab.Screen name="contactlist" component={ContactList} />
          <Tab.Screen name="addcontact" component={AddContact} />
          <Tab.Screen name="editcontact" component={EditContact} />
        </Tab.Navigator>
      </NavigationContainer>
    </View>
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

export default App;
