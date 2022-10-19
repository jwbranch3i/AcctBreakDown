package application;

import dataModel.AcctData;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
			Parent root = loader.load();
			MainController controller = loader.getController();
			controller.listTransactions();
			controller.listTotals();

			Scene scene = new Scene(root, 1100, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.setScene(new Scene(root, 900, 800));
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws Exception
	{
		super.init();
		if (!AcctData.getInstance().open())
		{
			System.out.println("FATAL ERROR: Couldn't connect to database");
			Platform.exit();
		}
	}

	@Override
	public void stop() throws Exception
	{
		super.stop();
		AcctData.getInstance().close();
	}

	public static void main(String[] args)
	{
		launch(args);
		System.out.println("*** finish ***");
	}

}
