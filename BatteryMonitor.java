
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.File;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class BatteryMonitor extends Application
{
    private final File infoFile = new File( "/proc/acpi/battery/BAT0/info" );
    private final File stateFile = new File( "/proc/acpi/battery/BAT0/state" );
    
    private BatteryInfo batteryInfo = null;
    private BatteryState batteryState = null;
    
    public static void main( String[] args )
    {
        Application.launch( args );
    }
    
    public void start( Stage stage )
    {   
        Group group = new Group();
        Scene scene = new Scene( group, 400, 300 );
        
        batteryInfo = new BatteryInfo();
        batteryState = new BatteryState();
        
        StackPane  state = new StackPane();
        Label powerPercent = new Label();
        
        Timeline timer = new Timeline( new KeyFrame( Duration.seconds( 1 ), new EventHandler<ActionEvent>()
        {
            public void handle( ActionEvent event )
            {   
                batteryInfo.update( readProcFile( infoFile ) );
                batteryState.update( readProcFile( stateFile ) );
                
                powerPercent.setText( (long)( (double)(batteryState.Remaining.getValue()) / (double)(batteryInfo.LastFullCapacity.getValue()) * 100 ) + " %");
                powerPercent.setFont( Font.font( "Arial", 40 ) );
                
                if( batteryState.ChargingState.getValue().equals( "charging" ) )
                {
                    state.setStyle( "-fx-background-color: #00ff00" );
                }
                else if( batteryState.ChargingState.getValue().equals( "discharging" ) )
                {
                    if( batteryState.Remaining.getValue() >= batteryInfo.CapacityWarn.getValue() )
                    {
                        state.setStyle( "-fx-background-color: #FFCC00" );
                    }
                    else
                    {
                        state.setStyle( "-fx-background-color: #aa0000" );
                    }
                }
                else if( batteryState.ChargingState.getValue().equals( "charged" ) )
                {
                    state.setStyle( "-fx-background-color: #008800" );
                }
            }
        } ) );
        timer.setCycleCount( Timeline.INDEFINITE );
        timer.play();
                
        state.getChildren().add( powerPercent );
        state.prefHeightProperty().bind( scene.heightProperty() );
        state.prefWidthProperty().bind( scene.widthProperty() );
        
        group.getChildren().add( state );
        
        stage.setTitle( "BatteryMonitor" );
        stage.setScene( scene );
        stage.show();
    }
    
    private String readProcFile( File procFile )
    {
        StringBuilder fileText = new StringBuilder();
        
        try
        {
            InputStreamReader isr = new InputStreamReader( new FileInputStream( procFile ) );
            char ch;
            int data = isr.read();
            while( data != -1 )
            {
                ch = (char)data;
                fileText.append( ch );
                data = isr.read();
            }
        }
        catch( IOException exception )
        {
            System.out.println( exception.getMessage() );
        }
        
        return fileText.toString();
    }
}
