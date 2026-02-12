import { Pressable, StatusBar, Text, useColorScheme, View } from 'react-native';
import { SafeAreaProvider } from 'react-native-safe-area-context';

function App() {
  const isDarkMode = useColorScheme() === 'dark';

  return (
    <SafeAreaProvider>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <AppContent />
    </SafeAreaProvider>
  );
}

function AppContent() {
  return (
    <View className="flex-1 items-center justify-center bg-white">
      <Pressable onPress={() => console.log('.')}>
        <Text className="text-xl font-bold text-red-500">
          Welcome to Nativewind! 1@!
        </Text>
      </Pressable>
    </View>
  );
}

export default App;
