
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleLongProperty;

public class BatteryState
{
    SimpleStringProperty    Present         = null;
    SimpleStringProperty    CapacityState   = null;
    SimpleStringProperty    ChargingState   = null;
    SimpleLongProperty      PresentRate     = null;
    SimpleStringProperty    PresentRateUts  = null;
    SimpleLongProperty      Remaining       = null;
    SimpleStringProperty    RemainingUts    = null;
    SimpleLongProperty      PresentVoltage  = null;
    SimpleStringProperty    PresentVoltUts  = null;
    
    public BatteryState()
    {
        Present         = new SimpleStringProperty();
        CapacityState   = new SimpleStringProperty();
        ChargingState   = new SimpleStringProperty();
        PresentRate     = new SimpleLongProperty();
        PresentRateUts  = new SimpleStringProperty();
        Remaining       = new SimpleLongProperty();
        RemainingUts    = new SimpleStringProperty();
        PresentVoltage  = new SimpleLongProperty();
        PresentVoltUts  = new SimpleStringProperty();
    }
    
    public void update( String contents )
    {
        String[] lines = contents.split( "\\n" );
        for( String line : lines )
        {
            String[] tokens = line.split( ":\\s+" );
            
            if( tokens[0].equals( "present" ) )
            {
                if( tokens.length > 1 )
                {
                    Present.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "capacity state" ) )
            {
                if( tokens.length > 1 )
                {
                    CapacityState.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "charging state" ) )
            {
                if( tokens.length > 1 )
                {
                    ChargingState.setValue( tokens[1] );
                }
            }
            else if( tokens[0].equals( "present rate" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    PresentRate.setValue( Long.parseLong( values[0] ) );
                    PresentRateUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "remaining capacity" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    Remaining.setValue( Long.parseLong( values[0] ) );
                    RemainingUts.setValue( values[1] );
                }
            }
            else if( tokens[0].equals( "present voltage" ) )
            {
                if( tokens.length > 1 )
                {
                    String[] values = tokens[1].split( "\\s+" );
                    PresentVoltage.setValue( Long.parseLong( values[0] ) );
                    PresentVoltUts.setValue( values[1] );
                }
            }
        }
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append( Present.getValue() );
        builder.append( "  " );
        builder.append( CapacityState.getValue() );
        builder.append( "  " );
        builder.append( ChargingState.getValue() );
        builder.append( "  " );
        builder.append( PresentRate.getValue() );
        builder.append( " " );
        builder.append( PresentRateUts.getValue() );
        builder.append( "  " );
        builder.append( Remaining.getValue() );
        builder.append( " " );
        builder.append( RemainingUts.getValue() );
        builder.append( "  " );
        builder.append( PresentVoltage.getValue() );
        builder.append( " " );
        builder.append( PresentVoltUts.getValue() );
        builder.append( "  " );
        
        return builder.toString();
    }
}
